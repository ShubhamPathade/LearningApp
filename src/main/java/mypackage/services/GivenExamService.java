package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.ContentQuestion;
import mypackage.model.ExamDetail;
import mypackage.model.ExamQuestion;
import mypackage.model.GivenExamModel;
import mypackage.model.StudentDetail;
import mypackage.model.StudentExamModel;
import mypackage.model.Topic;
import mypackage.model.TopicContent;
import mypackage.repository.ContentQuestionRepository;
import mypackage.repository.ExamDetailRepository;
import mypackage.repository.ExamQuestionRepository;
import mypackage.repository.StudentDetailRepository;
import mypackage.repository.TopicContentRepository;
import mypackage.repository.TopicRepository;
//import mypackage.repository.ViewRepository;

@Service
public class GivenExamService {

	@Autowired
	ExamDetailRepository examDetailRepo;

//	@Autowired
//	ViewRepository vwrepo;

	@Autowired
	StudentDetailRepository studentDetailRepo;

	@Autowired
	ContentQuestionRepository contentQuestionRepo;

	@Autowired
	ExamQuestionRepository examQuestionRepo;

	@Autowired
	TopicContentRepository topicContentRepo;

	@Autowired
	TopicRepository topicRepo;

	// Exam Details With Topic Function Code Opening.

	public List<GivenExamModel> GetGivenExamDataById(int stud_id) {
		List<GivenExamModel> lst = new ArrayList<GivenExamModel>();
		String topic = "";
		int sub_opt = 0;
		int topic_id = 0;
		for (ExamDetail e : examDetailRepo.findAll()) {
			if (e.getStudentDetail().getStudent_id() == stud_id) {
				ExamDetail ed = new ExamDetail(e.getExam_id(), null, e.getExam_date(), e.getStart_time(),
						e.getEnd_time(), 0, null);
				for (ExamQuestion eq : examQuestionRepo.findAll()) {
					if (ed.getExam_id() == eq.getExamDetail().getExam_id()) {
						ExamQuestion exq = new ExamQuestion(eq.getExam_question_id(), null, eq.getContentQuestion(),
								eq.getSubmited_option_number());
						sub_opt = exq.getSubmited_option_number();
//						System.out.println(exq.getExam_question_id()+" "+exq.getSubmited_option_number());
						for (ContentQuestion cq : contentQuestionRepo.findAll()) {
							if (cq.getQuestion_id() == exq.getContentQuestion().getQuestion_id()) {
								ContentQuestion cqq = new ContentQuestion(cq.getQuestion_id(), cq.getTopicContent(),
										cq.getQuestion(), cq.getOption1(), cq.getOption2(), cq.getOption3(),
										cq.getOption4(), cq.getCorrect_option_number(), 0, null);
//								System.out.println(cqq.getQuestion_id());
								for (TopicContent tc : topicContentRepo.findAll()) {
									if (tc.getContent_id() == cqq.getTopicContent().getContent_id()) {
										TopicContent tcc = new TopicContent(tc.getContent_id(), tc.getContent_name(),
												tc.getTopic(), tc.getTblcontent_tutorial(), 0, null);
//										System.out.println(tcc.getContent_id()+" "+tc.getContent_name());
										for (Topic t : topicRepo.findAll()) {
											if (t.getTopic_id() == tcc.getTopic().getTopic_id()) {
//												Topic tp = new Topic(t.getTopic_id(), t.getTopic_name(), 0, null);
												Topic tp=new Topic(t.getTopic_id(), t.getTopic_name(), t.getFlag(), null, null);
												System.out.println(tp.getTopic_id() + " " + tp.getTopic_name());
												topic = tp.getTopic_name();
												topic_id = tp.getTopic_id();
												break;
											}
										}
									}
								}
							}
						}
					}
				}

				GivenExamModel gem = new GivenExamModel(topic_id, topic, e.getExam_date(), e.getStart_time(),
						e.getEnd_time(), e.getExam_id(), sub_opt);
				lst.add(gem);
			}
		}
		return lst;
	}

}
