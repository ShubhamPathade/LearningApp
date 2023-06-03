package mypackage.controller;


import mypackage.services.*;
import mypackage.model.*;

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

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")
public class TopicContentController {

	@Autowired
	TopicContentServices contentServices;
	
	//Topic API's Code Opening.
	
	@PostMapping("api/topic")
	public Topic AddTopic(@RequestBody Topic tp) {
		return contentServices.AddNewTopic(tp);
	}
	
	@GetMapping("api/topic")
	public List<Topic> GetAllTopics() {
		return contentServices.GetAllTopics();
	}
	//
//	@GetMapping("api/topicContentByid/{id}")
//	public List<Topic>GetTopicWiseContent(@PathVariable("id")int id){
//		return contentServices.GetTopiWiseContent(id);
//	}
	//
	@PutMapping("api/topic")
	public Topic UpdateTopic(@RequestBody Topic tp) {
		return contentServices.UpdateTopic(tp);
	}
	
	@GetMapping("api/topic/{id}")
	public Topic GetTopicById(@PathVariable("id") int id) {
		return contentServices.GetTopicById(id);
	}
	
	@DeleteMapping("api/topic/{id}")
	public Topic DeleteTopicById(@PathVariable("id")int id) {
		return contentServices.DeleteTopic(id);
	}
	
	//Topic API's Code CLosing.
	
	//===========================================================================================================//
	
	//Topic Content API's Code Opening.

	@PostMapping("api/topicContent")
	public TopicContent AddNewTopicContent(@RequestBody TopicContent tc) {
		System.out.println(tc.getContent_name());
		return contentServices.AddNewTopicContent(tc);
	}
	
	@GetMapping("api/topicContent")
	public List<TopicContent>GetAllTopicContent(){
		return contentServices.GetAllTopicContent();
	}
	
	@GetMapping("api/topicContent/{id}")
	public TopicContent GetTopicContentById(@PathVariable("id")int id) {
		return contentServices.GetTopicContentById(id);
	}
	//
	@GetMapping("api/topicContentByTopicId/{id}")
	public List<TopicContent>getTopicContentByTopicId(@PathVariable("id")int id){
		return contentServices.GetContentByTopicId(id);
	}
	//
	@PutMapping("api/topicContent")
	public TopicContent UpdateTopicContent(@RequestBody TopicContent tc) {
		System.out.println(tc.getTopic().getTopic_id()+" "+tc.getContent_id());
		return contentServices.UpdateTopicContent(tc);
	}
	
	@DeleteMapping("api/topicContent/{id}")
	public TopicContent DeleteTopicContent(@PathVariable("id")int id) {
		return contentServices.DeleteTopicContent(id);
	}
	
	//Content Question API's Code Opening.

	@PostMapping("api/contentQuestion")
	public ContentQuestion AddNewContentQuestion(@RequestBody ContentQuestion cq) {
		System.out.println(cq.getQuestion()+" "+cq.getTopicContent().getContent_id());
		return contentServices.AddNewContentQuestion(cq);
	}
	
	@GetMapping("api/contentQuestion")
	public List<ContentQuestion>GetAllContentQuestion(){
		return contentServices.GetAllContentQuestion();
	}
	
	@GetMapping("api/contentQuestion/{id}")
	public ContentQuestion GetContentQuestionById(@PathVariable("id")int id) {
		return contentServices.GetContentQuestionById(id);
	}
	
	@PutMapping("api/contentQuestion")
	public ContentQuestion UpdateContentQuestion(@RequestBody ContentQuestion cq) {
		return contentServices.UpdateContentQuestion(cq);
	}
	
	@DeleteMapping("api/contentQuestion/{id}")
	public ContentQuestion DeleteContentQuestion(@PathVariable("id")int id) {
		return contentServices.DeleteContenQuestion(id);
	}
	
	//Content Question API's Code Closing.

	
}
