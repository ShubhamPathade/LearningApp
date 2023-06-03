package mypackage.controller;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sun.mail.imap.YoungerTerm;

import mypackage.services.*;
import mypackage.services.fileuploading.FileStorageService;
import mypackage.services.fileuploading.UploadFileResponseModel;
import mypackage.model.*;
@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
public class StudentController {
	
	private static final Logger logger= LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentServices studentServices;
	
	@Autowired 
	StudentEmailService emailService;
	
	@Autowired
	private FileStorageService fileStorageService;
	
	//==================================Student Details Api Code Opening============================================//
	
	@GetMapping("api/newStudentCode") // New Student Code Function.
	public StudentDetail NewStudentCode() {
		String scode=studentServices.NextStudentCode();
		StudentDetail sd=new StudentDetail(0, "", scode, "", "", "", "","", 0, null,null);
		return sd;
	}
	
	@GetMapping("api/getStudentIdPassword")
	public List<StudentDetail>GetStudentIdPass(){
		return studentServices.GetStudentPasswordId();
	}
	
	
	@PostMapping("/uploadFile")
	public UploadFileResponseModel UploadFile(@RequestParam("file")MultipartFile file) {
		String fileName=fileStorageService.storeFile(file);
		String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile")
				.path(fileName)
				.toUriString();
		return new UploadFileResponseModel(fileName, fileDownloadUri, file.getContentType(),file.getSize());
	}
	
	
	@GetMapping("api/studentDetail")
	public List<StudentDetail>GetAllStudentDetails(){
		List<StudentDetail>lst=new ArrayList<StudentDetail>();
		for(StudentDetail e:studentServices.GetAllStudentsDetail()) {
			String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/downloadFile/")
					.path(e.getProfile_photo())
					.toUriString();
			StudentDetail sd= new StudentDetail(e.getStudent_id(), e.getStudent_name(), e.getStudent_code(), e.getEmail_address(), e.getMobile_number(), fileDownloadUri, e.getCity(), "", e.getFlag(), null, null);
			lst.add(sd);
		}
		return lst;
	}
	// Get By Id
	@GetMapping("api/studentDetailById/{id}")
	public StudentDetail GetStudentDetailById(@PathVariable("id")int id) {
		StudentDetail s=studentServices.GetStudentDetailById(id);
		String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile/")
				.path(s.getProfile_photo())
				.toUriString();
//		StudentDetail dss = new StudentDetail(student_id, student_name, student_code, email_address, mobile_number, profile_photo, city, password, flag, examDetail, studentQualification)
		StudentDetail sd=new StudentDetail(s.getStudent_id(), s.getStudent_name(), s.getStudent_code(), s.getEmail_address(), s.getMobile_number(), fileDownloadUri, s.getCity(), "", s.getFlag(), null, s.getStudentQualification());
		return sd;
	}
	
	
	
	@PostMapping("/api/studentDetail")
	public StudentDetail AddNewStudentDetails(@RequestParam("student_name")String student_name,@RequestParam("student_code")String student_code,@RequestParam("email_address")String email_address,@RequestParam("mobile_number")String mobile_number,@RequestParam("file")MultipartFile file,@RequestParam("city")String city) {
		String fileName=fileStorageService.storeFile(file);
		StudentDetail e=new StudentDetail(0, student_name, student_code, email_address, mobile_number, fileName, city, "", 0, null, null);
		String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile/")
				.path(fileName)
				.toUriString();
		UploadFileResponseModel r=new UploadFileResponseModel(fileName, fileDownloadUri, file.getContentType(), file.getSize());
		studentServices.AddNewStudentDetails(e);
		return e;
	}
	
//	@PostMapping("/uploadMultipleFiles")
//	public List<Object>uploadMultipleFiles(@RequestParam("files")MultipartFile[] files){
//		return Arrays.asList(files)
//				.stream()
//				.map(file->uploadFile(file))
//				.collect(Collectors.toList());
//	}
	
	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource>downloadFile(@PathVariable String fileName,HttpServletRequest request){
		// Load file as Resource
		Resource resource=fileStorageService.loadFileAsResource(fileName);
		
		// Try to determine file's content type
		String contentType=null;
		try {
			contentType=request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			// TODO: handle exception
			logger.info("Could not determine file type");
		}
		
		// Fallback to the default content type if type could not be determined
		
		if(contentType==null) {
			contentType="application/octet-stream";
		}
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
//				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+resource.getFilename()+"\"")
				.header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+resource.getFilename()+"\"")
				.body(resource);
	}
	
	
	@PutMapping("api/studentDetail")
	public StudentDetail UpdateStudentDetails(@RequestBody StudentDetail stud) {
		return studentServices.UpdateStudentDetail(stud);
	}
	
	@DeleteMapping("api/studentDetail/{id}")
	public StudentDetail DeleteStudentDetail(@PathVariable("id")int id) {
		return studentServices.DeleteStudenDetail(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//==================================Student Details Api Code Closing============================================//

	@GetMapping("api/studentQualification")
	public List<StudentQualification>GetAllStudentQualification(){
		return studentServices.GetAllQualification();
	}
	
	@PostMapping("api/studentQualification")
	public StudentQualification AddNewQualification(@RequestBody StudentQualification sq) {
		return studentServices.AddNewQulification(sq);
	}
	
	@GetMapping("api/studentQualification/{id}")
	public StudentQualification GetQualificationById(@PathVariable("id")int id) {
		return studentServices.GetQualificationById(id);
	}
	
	@PutMapping("api/studentQualification")
	public StudentQualification UpdateQualification(@RequestBody StudentQualification sq) {
		return studentServices.UpdateQualification(sq);
	}
	
	@DeleteMapping("api/studentQualification/{id}")
	public StudentQualification DeleteQualification(@PathVariable("id")int id) {
		return studentServices.DeleteQualification(id);
	}
}
