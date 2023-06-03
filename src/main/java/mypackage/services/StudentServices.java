package mypackage.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.StudentDetail;
import mypackage.model.StudentEmail;
import mypackage.model.StudentQualification;
import mypackage.repository.StudentDetailRepository;
import mypackage.repository.StudentQualificationRepository;

@Service
public class StudentServices {

	@Autowired
	StudentDetailRepository studentDetailRepo;
	
	@Autowired
	StudentQualificationRepository studentQualificationRepo;
	
	@Autowired
	StudentEmailService emailService;
	
	//========================Student Detail Services Code Opening=======================================//
	
	public String GeneratePassword(int size) { // Random Password Generating Function.
		String data="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()";
		String password="";
		Random r=new Random();
		for(int i=0;i<size;i++) {
			password+=data.charAt(r.nextInt(0,data.length()-1));
		}
		return password;
	}
	
	public String NextStudentCode() {
		String scode="";
		List<StudentDetail>lst=studentDetailRepo.findAll();
		int id=0;
		if(lst.size()>0) {
			id=lst.size()+1;
		}else {
			id=1;
		}
		
		scode="S";
		if(id<10) {
			scode=scode+"00000000"+id;
		}
		else if(id>=10&&id<99) {
			scode=scode+"0000000"+id;
		}
		else if(id>100&&id<999) {
			scode=scode+"000000"+id;
		}
		else if(id>=1000&&id<9999) {
			scode=scode+"00000"+id;
		}
		return scode;
	}
	
	
	public StudentDetail AddNewStudentDetails(StudentDetail s) { // Add New Student Details Function.
		String password=GeneratePassword(8);
		StudentEmail em=new StudentEmail(s.getEmail_address(), "Hii Dear Student Here Are Your User Id And Password .","User Id Is : "+s.getStudent_code()+ " And Your Password Is : "+password+" .");
		emailService.SendEmail(em);
		StudentDetail sd=new StudentDetail(s.getStudent_id(), s.getStudent_name(), s.getStudent_code(), s.getEmail_address(), s.getMobile_number(), s.getProfile_photo(), s.getCity(), password, s.getFlag(), null, s.getStudentQualification());
		return studentDetailRepo.save(sd);
	}
	
	
	public List<StudentDetail>GetAllStudentsDetail(){ // Get All Student Details Function.
		List<StudentDetail>lst=new ArrayList<StudentDetail>();
		for(StudentDetail s:studentDetailRepo.findAll()) {
			StudentDetail sd=new StudentDetail(s.getStudent_id(), s.getStudent_name(), s.getStudent_code(), s.getEmail_address(), s.getMobile_number(), s.getProfile_photo(), s.getCity(),"", s.getFlag(), null, s.getStudentQualification());
			lst.add(sd);
		}
		return lst;
	}
	
	public List<StudentDetail> GetStudentPasswordId() {
		List<StudentDetail>lst=new ArrayList<StudentDetail>();
		for(StudentDetail s:studentDetailRepo.findAll()) {
			StudentDetail sd=new StudentDetail(s.getStudent_id(), s.getStudent_name(), s.getStudent_code(), "", "", "", "", s.getPassword(), s.getFlag(), null, null);
			lst.add(sd);
		}
		return lst;
	}
	
	public StudentDetail GetStudentDetailById(int id) { // Get Student Detail By Id.
		StudentDetail s=studentDetailRepo.findById(id).get();
		StudentDetail stud=new StudentDetail(s.getStudent_id(), s.getStudent_name(), s.getStudent_code(), s.getEmail_address(), s.getMobile_number(), s.getProfile_photo(), s.getCity(),"", s.getFlag(), null, s.getStudentQualification());
		return stud;
	}
	
	public StudentDetail UpdateStudentDetail(StudentDetail stud) { // Update Student Details Function.
		return studentDetailRepo.save(stud);
	}
	
	public StudentDetail DeleteStudenDetail(int id) { // Delete Studend Detials By Id.
		StudentDetail s=GetStudentDetailById(id);
		studentDetailRepo.delete(s);
		return s;
	}
	
	//========================Student Detail Services Code Closing=======================================//
	
	//====================================================================================================//
	
	//========================Student Qualification Services Code Opening=================================//

	public StudentQualification AddNewQulification(StudentQualification squali) { // Add New Student Qualification Function.
		return studentQualificationRepo.save(squali);
	}
	
	public List<StudentQualification> GetAllQualification(){ // Get All Student Qualification Function.
		List<StudentQualification>lst=new ArrayList<StudentQualification>();
		for(StudentQualification s:studentQualificationRepo.findAll()) {
//			StudentDetail sd=new StudentDetail(s.getStudentDetail().getStudent_id(), s.getStudentDetail().getStudent_name(), s.getStudentDetail().getStudent_code(), s.getStudentDetail().getEmail_address(), s.getStudentDetail().getMobile_number(), s.getStudentDetail().getProfile_photo(), s.getStudentDetail().getCity(), s.getStudentDetail().getFlag(), null, null);
			StudentQualification sq=new StudentQualification(s.getQualification_id(), s.getQualification(), s.getUniversity(), s.getPassing_year(), s.getPercentage(), s.getFlag(), null);
			lst.add(sq);
		}
		return lst;
	}
	
	public StudentQualification GetQualificationById(int id) { // Get Student Qualification By Id Function.
		StudentQualification s=studentQualificationRepo.findById(id).get();
		StudentQualification sq=new StudentQualification(s.getQualification_id(), s.getQualification(), s.getUniversity(), s.getPassing_year(), s.getPercentage(), s.getFlag(), null);
		return sq;
	}
	
	public StudentQualification DeleteQualification(int id) { // Delete Student Qualification Function.
		StudentQualification sq=GetQualificationById(id);
	    studentQualificationRepo.delete(sq);
	    return sq;
	}
	
	public StudentQualification UpdateQualification(StudentQualification sq) { // Update Student Qualification Function.
		return studentQualificationRepo.save(sq);
	}
}
