package mypackage.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

//@Entity
//
//@Table(name="vw_exams")
public class StudentExamModel {

//	@Id
	private int student_id;
	private String student_name;
	private String topic_name;
	private String exam_date;
	private String start_time;
	private String end_time;
	public StudentExamModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentExamModel(int student_id, String student_name, String topic_name, String exam_date, String start_time,
			String end_time) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.topic_name = topic_name;
		this.exam_date = exam_date;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getTopic_name() {
		return topic_name;
	}
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	public String getExam_date() {
		return exam_date;
	}
	public void setExam_date(String exam_date) {
		this.exam_date = exam_date;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
}
