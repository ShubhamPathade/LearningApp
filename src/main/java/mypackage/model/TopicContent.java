package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbltopic_contents")
public class TopicContent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int content_id;
	private String content_name;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "topic_id")
	private Topic topic;
	@Column(name = "tblcontent_tutorial",length = 1000)
	private String tblcontent_tutorial;
	@ColumnDefault("0")
	private int flag;
	@OneToMany(mappedBy = "topicContent",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("topicContent")
	private Set<ContentQuestion>contentQuestion;
	public TopicContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TopicContent(int content_id, String content_name, Topic topic, String tblcontent_tutorial, int flag,
			Set<ContentQuestion> contentQuestion) {
		super();
		this.content_id = content_id;
		this.content_name = content_name;
		this.topic = topic;
		this.tblcontent_tutorial = tblcontent_tutorial;
		this.flag = flag;
		this.contentQuestion = contentQuestion;
	}
	public int getContent_id() {
		return content_id;
	}
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}
	public String getContent_name() {
		return content_name;
	}
	public void setContent_name(String content_name) {
		this.content_name = content_name;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getTblcontent_tutorial() {
		return tblcontent_tutorial;
	}
	public void setTblcontent_tutorial(String tblcontent_tutorial) {
		this.tblcontent_tutorial = tblcontent_tutorial;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Set<ContentQuestion> getContentQuestion() {
		return contentQuestion;
	}
	public void setContentQuestion(Set<ContentQuestion> contentQuestion) {
		this.contentQuestion = contentQuestion;
	}
	
}
