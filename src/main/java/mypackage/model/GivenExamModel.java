package mypackage.model;

import java.util.Set;

public class GivenExamModel {
	
	private int topic_id;
	private String topic_name;
	private String exam_date;
	private String start_time;
	private String end_time;
	private int exam_id;
	private int submited_option_number;
	public GivenExamModel(int topic_id, String topic_name, String exam_date, String start_time, String end_time,
			int exam_id, int submited_option_number) {
		super();
		this.topic_id = topic_id;
		this.topic_name = topic_name;
		this.exam_date = exam_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.exam_id = exam_id;
		this.submited_option_number = submited_option_number;
	}

	public int getSubmited_option_number() {
		return submited_option_number;
	}

	public void setSubmited_option_number(int submited_option_number) {
		this.submited_option_number = submited_option_number;
	}

	public GivenExamModel() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}

//	private Set<GivenExamStatus> givenquestions;
}
