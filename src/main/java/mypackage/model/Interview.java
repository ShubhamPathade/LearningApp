package mypackage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tblinterview")
public class Interview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int i_id;
	@Column(length = 1000)
	private String interview_question;
	@Column(length = 1000)
	private String interview_answer;
	@ColumnDefault("0")
	private int flag;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="topic_id")
	private Topic topic;
	public Interview() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Interview(int i_id, String interview_question, String interview_answer, Topic topic) {
		super();
		this.i_id = i_id;
		this.interview_question = interview_question;
		this.interview_answer = interview_answer;
		this.topic = topic;
	}
	public int getI_id() {
		return i_id;
	}
	public void setI_id(int i_id) {
		this.i_id = i_id;
	}
	public String getInterview_question() {
		return interview_question;
	}
	public void setInterview_question(String interview_question) {
		this.interview_question = interview_question;
	}
	public String getInterview_answer() {
		return interview_answer;
	}
	public void setInterview_answer(String interview_answer) {
		this.interview_answer = interview_answer;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
