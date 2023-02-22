package com.task3.sendingMail;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
	public class MailController {
		
		@RequestMapping(value = "/sendemail")
		   public String sendEmail() {
		      return "Email sent successfully";
		   }   

}
