package mypackage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import mypackage.model.StudentEmail;

@Service
public class StudentEmailService {

	@Autowired
	private JavaMailSender mailSender;
	@Value("${spring.mail.username}")
	private String sender;
	public String SendEmail(StudentEmail em) {
		try {
			SimpleMailMessage mail=new SimpleMailMessage();
			mail.setFrom(sender);
			mail.setTo(em.getEmail_address());
			mail.setSubject(em.getSubject());
			mail.setText(em.getMessage());
			mailSender.send(mail);
			
		} catch (Exception e) {
			// TODO: handle exception
			return(e.getMessage());
		}
		return "Email Sent Successfully";
	}
	
	
	
}
