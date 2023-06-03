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
@Table(name = "tblexam_details")
public class ExamDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int exam_id;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "student_id")
	private StudentDetail studentDetail;
	@Column(length = 40)
	private String exam_date;
	@Column(length = 20)
	private String start_time;
	private String end_time;
	@ColumnDefault("0")
	private int flag;
	@OneToMany(mappedBy = "examDetail",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("examDetail")
	private Set<ExamQuestion>examQuestion;
	public ExamDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExamDetail(int exam_id, StudentDetail studentDetail, String exam_date, String start_time, String end_time,
			int flag, Set<ExamQuestion> examQuestion) {
		super();
		this.exam_id = exam_id;
		this.studentDetail = studentDetail;
		this.exam_date = exam_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.flag = flag;
		this.examQuestion = examQuestion;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public StudentDetail getStudentDetail() {
		return studentDetail;
	}
	public void setStudentDetail(StudentDetail studentDetail) {
		this.studentDetail = studentDetail;
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
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Set<ExamQuestion> getExamQuestion() {
		return examQuestion;
	}
	public void setExamQuestion(Set<ExamQuestion> examQuestion) {
		this.examQuestion = examQuestion;
	}
	
}
