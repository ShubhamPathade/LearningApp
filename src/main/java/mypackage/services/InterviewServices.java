package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Interview;
import mypackage.model.Topic;
import mypackage.repository.InterviewRepository;

@Service
public class InterviewServices {

	@Autowired
	InterviewRepository interviewRepo;
	
	public List<Interview>GetAllInterviewQuestions(){ // Get All Interview Questions And Answer Function.
		List<Interview>lst=new ArrayList<Interview>();
		for(Interview i:interviewRepo.findAll()) {
			Topic tp=new Topic(i.getTopic().getTopic_id(), i.getTopic().getTopic_name(), i.getTopic().getFlag(), null,null);
			Interview im=new Interview(i.getI_id(), i.getInterview_question(), i.getInterview_answer(), tp);
			lst.add(im);
		}
		return lst;
	}
	
	public Interview AddInterviewQuestionAns(Interview i) { // Add Interview Question Function.
		Interview iv= interviewRepo.save(i);
		return iv;
	}
	
	
	
}
