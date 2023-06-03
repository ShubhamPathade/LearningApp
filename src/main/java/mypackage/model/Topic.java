package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbltopics")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int topic_id;
	@Column(name = "topic_name",unique = true,nullable = false)
	private String topic_name;
	@ColumnDefault("0")
	private int flag;
	@OneToMany(mappedBy = "topic",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("topic")
	private Set<TopicContent>topicContent;
	@OneToMany(mappedBy = "topic",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("topic")
	private Set<Interview>interview;
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Topic(int topic_id, String topic_name, int flag, Set<TopicContent> topicContent, Set<Interview> interview) {
		super();
		this.topic_id = topic_id;
		this.topic_name = topic_name;
		this.flag = flag;
		this.topicContent = topicContent;
		this.interview = interview;
	}
	public int getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}
	public String getTopic_name() {
		return topic_name;
	}
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Set<TopicContent> getTopicContent() {
		return topicContent;
	}
	public void setTopicContent(Set<TopicContent> topicContent) {
		this.topicContent = topicContent;
	}
	public Set<Interview> getInterview() {
		return interview;
	}
	public void setInterview(Set<Interview> interview) {
		this.interview = interview;
	}
	
}
