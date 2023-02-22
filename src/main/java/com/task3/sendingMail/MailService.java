package com.task3.sendingMail;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

//import freemarker.template.Configuration;


@Service
public class MailService {

	@Autowired
	private JavaMailSender mailsender;



	public void sendEmail(String toEmail, String subject, String body) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("tulasi.maisa@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		mailsender.send(message);
	}

	public void mailAttachment(String toEmail, String subject, String body, String attachement)
			throws MessagingException {

		MimeMessage mimeMessage = mailsender.createMimeMessage();

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setFrom("tulasi.maisa@gmail.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);

		FileSystemResource fileSystem = new FileSystemResource(new File(attachement));

		mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);

		mailsender.send(mimeMessage);

	}

}
