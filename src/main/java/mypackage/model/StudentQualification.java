package mypackage.model;

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
@Table(name = "tblstudent_qualifications")
public class StudentQualification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qualification_id;
	private String qualification;
	private String university;
	private String passing_year;
	private float percentage;
	@ColumnDefault("0")
	private int flag;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "student_id")
	private StudentDetail studentDetail;
	public StudentQualification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentQualification(int qualification_id, String qualification, String university, String passing_year,
			float percentage, int flag, StudentDetail studentDetail) {
		super();
		this.qualification_id = qualification_id;
		this.qualification = qualification;
		this.university = university;
		this.passing_year = passing_year;
		this.percentage = percentage;
		this.flag = flag;
		this.studentDetail = studentDetail;
	}
	public int getQualification_id() {
		return qualification_id;
	}
	public void setQualification_id(int qualification_id) {
		this.qualification_id = qualification_id;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getPassing_year() {
		return passing_year;
	}
	public void setPassing_year(String passing_year) {
		this.passing_year = passing_year;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public StudentDetail getStudentDetail() {
		return studentDetail;
	}
	public void setStudentDetail(StudentDetail studentDetail) {
		this.studentDetail = studentDetail;
	}
	
}
