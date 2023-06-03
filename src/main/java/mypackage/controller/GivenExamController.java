package mypackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.ExamDetail;
import mypackage.model.GivenExamModel;
import mypackage.model.StudentExamModel;
import mypackage.services.GivenExamService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.POST},allowedHeaders = "*")
public class GivenExamController {
	
	@Autowired
	GivenExamService givenExamService;

	@GetMapping("api/getGivenExam/{id}")
	public List<GivenExamModel>GetData(@PathVariable("id")int id){
		return givenExamService.GetGivenExamDataById(id);
	}
	
//	@GetMapping("api/exams")
//	public List<StudentExamModel>GetData(){
//		return givenExamService.FetchExams();
//	}
	
}
