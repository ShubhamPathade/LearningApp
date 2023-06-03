package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.repository.*;
import mypackage.model.*;
@Service
public class ExamServices {

	@Autowired
	ExamDetailRepository examDetailRepo;
	
	@Autowired
	ExamQuestionRepository examQuestionRepo;
	
	
	@Autowired
	ContentQuestionRepository contentQuestionRepo;
	
	//===================================Exam Details Table Services Code Opening============================//
	
	public List<ExamDetail>GetAllExamDetails(){ // Get All Exam Details Function.
		List<ExamDetail>lst=new ArrayList<ExamDetail>();
		for(ExamDetail e:examDetailRepo.findAll()) {
			StudentDetail sd=new StudentDetail(e.getStudentDetail().getStudent_id(), e.getStudentDetail().getStudent_name(), e.getStudentDetail().getStudent_code(), e.getStudentDetail().getEmail_address(), e.getStudentDetail().getMobile_number(), e.getStudentDetail().getProfile_photo(), e.getStudentDetail().getCity(),e.getStudentDetail().getPassword(), e.getStudentDetail().getFlag(), null, null);
			ExamDetail ed=new ExamDetail(e.getExam_id(), sd, e.getExam_date(), e.getStart_time(), e.getEnd_time(), e.getFlag(), e.getExamQuestion());
			lst.add(ed);
		}
		return lst;
	}
	
	//
	public List<ExamDetail>GetExamDetailByStudentId(int stud_id){// Get Exam Detail By Student Id Function.
		List<ExamDetail>lst=new ArrayList<ExamDetail>();
		for(ExamDetail e:examDetailRepo.findAll()) {
			if(e.getStudentDetail().getStudent_id()==stud_id) {
				StudentDetail sd=new StudentDetail(e.getStudentDetail().getStudent_id(), e.getStudentDetail().getStudent_name(), "","", "","", "", "", 0, null, null);
				ExamDetail ed=new ExamDetail(e.getExam_id(), sd, e.getExam_date(), e.getStart_time(), e.getEnd_time(), 0, null);
				lst.add(ed);
			}
		}
		return lst;
	}
	//
	public ExamDetail AddNewExamDetail(ExamDetail ed) { // Add New Exam Details Function.
		ExamDetail exd=new ExamDetail(0, ed.getStudentDetail(), ed.getExam_date(), ed.getStart_time(), ed.getEnd_time(), ed.getFlag(), null);
		ExamDetail e=examDetailRepo.save(exd);
		for(ExamQuestion eq:ed.getExamQuestion()) {
			ExamQuestion exq=new ExamQuestion(0, e, eq.getContentQuestion(), eq.getSubmited_option_number());
			examQuestionRepo.save(exq);
		}
		return e;
	}
	
	public ExamDetail GetExamDetailById(int id) { // Get Exam Details By Id Function.
		ExamDetail e=examDetailRepo.findById(id).get();
		StudentDetail sd=new StudentDetail(e.getStudentDetail().getStudent_id(), e.getStudentDetail().getStudent_name(), e.getStudentDetail().getStudent_code(), e.getStudentDetail().getEmail_address(), e.getStudentDetail().getMobile_number(), e.getStudentDetail().getProfile_photo(), e.getStudentDetail().getCity(),e.getStudentDetail().getPassword(), e.getStudentDetail().getFlag(), null, null);
		ExamDetail ed=new ExamDetail(e.getExam_id(), sd, e.getExam_date(), e.getStart_time(), e.getEnd_time(), e.getFlag(), null);
		return ed;
	}
	
	public ExamDetail DeletExamDetails(int id) { // Delete Exam Details Function.
		ExamDetail e=GetExamDetailById(id);
		examDetailRepo.delete(e);
		return e;
	}
	
	public ExamDetail UpdateExamDetail(ExamDetail ed) { // Update Exam Details Function.
		return examDetailRepo.save(ed);
	}
	
	//===================================Exam Details Table Services Code Closing============================//
	
	//=======================================================================================================//
	
	//===================================Exam Question Table Services Code Opening============================//

	public List<QuestionModel>GetQuestion(){
		List<QuestionModel>lst=new ArrayList<QuestionModel>();
		for(ContentQuestion q:contentQuestionRepo.findAll()) {
			String content_name=q.getTopicContent().getContent_name();
			int content_id=q.getTopicContent().getContent_id();
			String topic_name=q.getTopicContent().getTopic().getTopic_name();
			int topic_id=q.getTopicContent().getTopic().getTopic_id();
			QuestionModel qm=new QuestionModel(q.getQuestion_id(), q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4(), q.getCorrect_option_number(), content_id, content_name, topic_id, topic_name);
			lst.add(qm);
		}
		return lst;
	}
	
	public List<QuestionModel>GetTopicWiseQuestions(int topic_id){
		List<QuestionModel>lst=new ArrayList<QuestionModel>();
		for(QuestionModel q:GetQuestion()) {
			if(q.getTopic_id()==topic_id) {
				lst.add(q);
			}
		}
		return lst;
	}
	
	
//	public ExamQuestion GetExamQuestionById(int id) {
//		ExamQuestion
//	}
}
