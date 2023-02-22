package com.task3.sendingMail;

import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SendingMailApplication {

	@Autowired
	private MailService mailService;

	public static void main(String[] args) {
		SpringApplication.run(SendingMailApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() throws MessagingException {
		mailService.sendEmail("tulasi.maisa@gmail.com", "SpringBoot mail sending",

				"Hello," + "My new mail sending Program");

	}

	@EventListener(ApplicationReadyEvent.class)
	public void mailAttachement() throws MessagingException {
		mailService.mailAttachment("tulasi.maisa@gmail.com", "SpringBoot mail sending",

				"Hello," + "My new mail sending Program", "D:\\sheet.xlsx");
	}

}
