package org.outil.controller;

import org.outil.domain.User;
import org.outil.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

	@Autowired
	private NotificationService notificationService;

	@RequestMapping("/signup")
	public String signup() {
		return "Please sign up for our service !";
	}

	@RequestMapping("/signup-success")
	public String signupSuccess() {
		User user = new User();
		user.setFirstName("Amine");
		user.setLastName("Hanane");
		user.setEmailAdress("hananeamine70@gmail.com");
		try {
			System.out.println("good to send Mail !");

			this.notificationService.sendNotification(user);
			System.out.println("good to send Mail !");

		} catch (Exception e) {
			System.out.println("Failed to send Mail !");
		}
		// send email
		return "Thank you for registering with us !";
	}
}
