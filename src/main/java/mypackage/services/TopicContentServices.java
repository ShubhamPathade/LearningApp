package mypackage.services;

import mypackage.repository.*;
import mypackage.model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicContentServices {

	@Autowired
	TopicRepository topicRepo;
	@Autowired
	TopicContentRepository topicContentRepo;
	@Autowired
	ContentQuestionRepository contentQuestionRepo;

	// Topic Services Code Opening..

	public List<Topic> GetAllTopics() { // Get All Topics Function.
		List<Topic> lst = new ArrayList<Topic>();
		for (Topic t : topicRepo.findAll()) {
			Topic tp = new Topic(t.getTopic_id(), t.getTopic_name(), t.getFlag(), null,null);
			lst.add(tp);
		}
		return lst;
	}

	public Topic GetTopicById(int id) { // Get Topic By Id Function.
		Topic t = topicRepo.findById(id).get();
		Topic tp = new Topic(t.getTopic_id(), t.getTopic_name(), t.getFlag(), null,null);
		return tp;
	}

	//
	//
	public Topic AddNewTopic(Topic t) { // Add New Topic Function.

		Topic tp = new Topic(0, t.getTopic_name(), t.getFlag(), null,null);
		topicRepo.save(tp);
		return t;

	}

	public Topic UpdateTopic(Topic t) { // Update Topic Function.
		Topic tp = new Topic(t.getTopic_id(), t.getTopic_name(), t.getFlag(), null,null);
		return topicRepo.save(tp);
	}

	public Topic DeleteTopic(int id) { // Delete Topic By Id.
		Topic t = topicRepo.findById(id).get();
		Topic tp=new Topic(t.getTopic_id(), t.getTopic_name(), t.getFlag(), t.getTopicContent(),null);
		topicRepo.delete(tp);
		return t;
	}
	// Topic Services Code Closing..

	// ========================================================================================================//

	// Topic Content Services Code Opening..

	public List<TopicContent> GetAllTopicContent() { // Get All Topic Content Function.
		List<TopicContent> lst = new ArrayList<TopicContent>();
		for (TopicContent t : topicContentRepo.findAll()) {
			Topic tpp = new Topic(t.getTopic().getTopic_id(), t.getTopic().getTopic_name(), t.getTopic().getFlag(),
					null,null);
			TopicContent tp = new TopicContent(t.getContent_id(), t.getContent_name(), tpp, t.getTblcontent_tutorial(),
					t.getFlag(), null);
			lst.add(tp);
		}
		return lst;
	}
	
	//
	public List<TopicContent>GetContentByTopicId(int topic_id){ // Get Contents By Topic Id
		List<TopicContent>lst=new ArrayList<TopicContent>();
		for(TopicContent t:topicContentRepo.findAll()) {
			if(t.getTopic().getTopic_id()==topic_id) {
				Topic tp=new Topic(t.getTopic().getTopic_id(), t.getTopic().getTopic_name(), t.getTopic().getFlag(), null,null);
				TopicContent tc=new TopicContent(t.getContent_id(), t.getContent_name(), tp, t.getTblcontent_tutorial(), t.getFlag(), null);
				lst.add(tc);
			}
		}
		return lst;
	}
	//
	
	public TopicContent AddNewTopicContent(TopicContent t) { // Add New Topic Content Function.
		TopicContent tp = topicContentRepo.save(t);
		return tp;
	}

	public TopicContent GetTopicContentById(int id) { // Get Topic Content By Id Function.
		TopicContent t = topicContentRepo.findById(id).get();
		Topic tt = new Topic(t.getTopic().getTopic_id(), t.getTopic().getTopic_name(), t.getTopic().getFlag(), null,null);
		TopicContent tp = new TopicContent(t.getContent_id(), t.getContent_name(), tt, t.getTblcontent_tutorial(),
				t.getFlag(), null);
		return tp;
	}

	public TopicContent UpdateTopicContent(TopicContent t) { // Update Topic Content Function.
		Topic tt = new Topic(t.getTopic().getTopic_id(), t.getTopic().getTopic_name(), t.getTopic().getFlag(), null,null);
		TopicContent tp = new TopicContent(t.getContent_id(), t.getContent_name(), tt, t.getTblcontent_tutorial(),
				t.getFlag(), null);
		return topicContentRepo.save(tp);
	}

	public TopicContent DeleteTopicContent(int tid) { // Delete Topic Content Function.
//		TopicContent t = GetTopicContentById(tid);
		TopicContent t=topicContentRepo.findById(tid).get();
		TopicContent tc=new TopicContent(t.getContent_id(), t.getContent_name(), t.getTopic(), t.getTblcontent_tutorial(), t.getFlag(), t.getContentQuestion());
		topicContentRepo.delete(tc);
		return t;
	}

	// Topic Content Services Code Closing..

	// ========================================================================================================//

	// Content Question Services Code Opening..

	public List<ContentQuestion> GetAllContentQuestion() { // Get All Content Question Function.
		List<ContentQuestion> lst = new ArrayList<ContentQuestion>();
		for (ContentQuestion c : contentQuestionRepo.findAll()) {
		
			TopicContent tc = new TopicContent(c.getTopicContent().getContent_id(),
					c.getTopicContent().getContent_name(), null, c.getTopicContent().getTblcontent_tutorial(),
					c.getTopicContent().getFlag(), null);
			ContentQuestion cq = new ContentQuestion(c.getQuestion_id(), tc, c.getQuestion(), c.getOption1(),
					c.getOption2(), c.getOption3(), c.getOption4(), c.getCorrect_option_number(), c.getFlag(), null);
			lst.add(cq);
		}
		return lst;
	}

	public ContentQuestion GetContentQuestionById(int id) { // Get Content Question By Id Function.
		ContentQuestion c = contentQuestionRepo.findById(id).get();
		ContentQuestion cq = new ContentQuestion(c.getQuestion_id(), null, c.getQuestion(), c.getOption1(),
				c.getOption2(), c.getOption3(), c.getOption4(), c.getCorrect_option_number(), c.getFlag(), null);
		return cq;
	}

	public ContentQuestion AddNewContentQuestion(ContentQuestion cq) { // Add New Content Question Function.
		ContentQuestion c = contentQuestionRepo.save(cq);
		return c;
	}

	public ContentQuestion UpdateContentQuestion(ContentQuestion cq) { // Update Content Question Function.
		ContentQuestion c = new ContentQuestion(cq.getQuestion_id(), null, cq.getQuestion(), cq.getOption1(),
				cq.getOption2(), cq.getOption3(), cq.getOption4(), cq.getCorrect_option_number(), cq.getFlag(), null);
		contentQuestionRepo.save(c);
		return c;
	}

	public ContentQuestion DeleteContenQuestion(int id) { // Get Content Question By Id Function.
		ContentQuestion c = GetContentQuestionById(id);
		contentQuestionRepo.delete(c);
		return c;
	}

	// Content Question Services Code Closing..

}
