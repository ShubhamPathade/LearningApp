package mypackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import mypackage.model.*;
import mypackage.services.*;
@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")
public class ExamController {

	@Autowired
	ExamServices examServices;
	
	//================================Exam Detail API,s Code Opening====================================//
	
	@GetMapping("api/examDetail")
	public List<ExamDetail> GetAllExamDetail(){
		return examServices.GetAllExamDetails();
	}
	
 
	//
	@GetMapping("api/examDetailByStudentId/{id}")
	public List<ExamDetail>GetExamDetailByStudentId(@PathVariable("id")int id){
		return examServices.GetExamDetailByStudentId(id);
	}
	
	@GetMapping("api/examDetail/{id}")
	public ExamDetail GetExamDetailById(@PathVariable("id")int id) {
		return examServices.GetExamDetailById(id);
	}
	//
	@PostMapping("api/examDetail")
	public ExamDetail AddExamDetail(@RequestBody ExamDetail ed) {
		System.out.println(ed.getEnd_time()+" "+ed.getStart_time()+" "+ed.getExam_id()+" "+ed.getStudentDetail().getStudent_id());
		return examServices.AddNewExamDetail(ed);
	}
	//
	@PutMapping("api/examDetail")
	public ExamDetail UpdateExamDetail(@RequestBody ExamDetail ed) {
		return examServices.UpdateExamDetail(ed);
	}
	
	@DeleteMapping("api/examDetail/{id}")
	public ExamDetail DeleteExamDetail(@PathVariable("id") int id) {
		return examServices.DeletExamDetails(id);
	}
	
	//================================Exam Detail API,s Code Closing====================================//

	//==================================================================================================//
	
	//================================Exam Question API,s Code Opening==================================//
	
	@GetMapping("api/examquestion")
	public List<QuestionModel>GetExamQuestion(){
		return examServices.GetQuestion();
	}
	
	@GetMapping("api/topicWiseQuestions/{id}")
	public List<QuestionModel>GetExamQuestions(@PathVariable("id")int id){
		return examServices.GetTopicWiseQuestions(id);
	}
	
	//================================Exam Question API,s Code Closing==================================//

	//================================Solved Exam QUestions API,s Code Opening==================================//

}
