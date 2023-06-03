package mypackage.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblexam_question")
public class ExamQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int exam_question_id;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "exam_id")
	private ExamDetail examDetail;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "question_id")
	private ContentQuestion contentQuestion;
	private int submited_option_number;
	public ExamQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExamQuestion(int exam_question_id, ExamDetail examDetail, ContentQuestion contentQuestion,
			int submited_option_number) {
		super();
		this.exam_question_id = exam_question_id;
		this.examDetail = examDetail;
		this.contentQuestion = contentQuestion;
		this.submited_option_number = submited_option_number;
	}
	public int getExam_question_id() {
		return exam_question_id;
	}
	public void setExam_question_id(int exam_question_id) {
		this.exam_question_id = exam_question_id;
	}
	public ExamDetail getExamDetail() {
		return examDetail;
	}
	public void setExamDetail(ExamDetail examDetail) {
		this.examDetail = examDetail;
	}
	public ContentQuestion getContentQuestion() {
		return contentQuestion;
	}
	public void setContentQuestion(ContentQuestion contentQuestion) {
		this.contentQuestion = contentQuestion;
	}
	public int getSubmited_option_number() {
		return submited_option_number;
	}
	public void setSubmited_option_number(int submited_option_number) {
		this.submited_option_number = submited_option_number;
	}
	
	
}
