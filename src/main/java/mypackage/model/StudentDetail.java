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
@Table(name = "tblstudent_details")
public class StudentDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	private String student_name;
	@Column(name = "student_code", length = 100,nullable = false,unique = true)
	private String student_code;
	@Column(name = "email_address",nullable = false,unique = true)
	private String email_address;
	@Column(length = 20)
	private String mobile_number;
	@Column(length = 100)
	private String profile_photo;
	private String city;
	private String password;
	@ColumnDefault("0")
	private int flag;
	@OneToMany(mappedBy = "studentDetail",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("studentDetail")
	private Set<ExamDetail>examDetail;
	@OneToMany(mappedBy = "studentDetail",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("studentDetail")
	private Set<StudentQualification>studentQualification;
	public StudentDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentDetail(int student_id, String student_name, String student_code, String email_address,
			String mobile_number, String profile_photo, String city, String password, int flag,
			Set<ExamDetail> examDetail, Set<StudentQualification> studentQualification) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_code = student_code;
		this.email_address = email_address;
		this.mobile_number = mobile_number;
		this.profile_photo = profile_photo;
		this.city = city;
		this.password = password;
		this.flag = flag;
		this.examDetail = examDetail;
		this.studentQualification = studentQualification;
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
	public String getStudent_code() {
		return student_code;
	}
	public void setStudent_code(String student_code) {
		this.student_code = student_code;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getProfile_photo() {
		return profile_photo;
	}
	public void setProfile_photo(String profile_photo) {
		this.profile_photo = profile_photo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Set<ExamDetail> getExamDetail() {
		return examDetail;
	}
	public void setExamDetail(Set<ExamDetail> examDetail) {
		this.examDetail = examDetail;
	}
	public Set<StudentQualification> getStudentQualification() {
		return studentQualification;
	}
	public void setStudentQualification(Set<StudentQualification> studentQualification) {
		this.studentQualification = studentQualification;
	}
	
	
}
