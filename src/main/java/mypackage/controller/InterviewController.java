package mypackage.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.Interview;
import mypackage.services.InterviewServices;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")
public class InterviewController {

	@Autowired
	InterviewServices interviewServices;
	
	// Get All Interview QA API 
	@GetMapping("api/interview")
	public List<Interview>GetAllInterviewQA(){
		return interviewServices.GetAllInterviewQuestions();
	}
	
	// Add New Interview Question API
	@PostMapping("api/interview")
	public Interview AddInterviewQA(@RequestBody Interview iv) {
		System.out.println(iv.getTopic().getTopic_id());
		return interviewServices.AddInterviewQuestionAns(iv);
	}
	
}
