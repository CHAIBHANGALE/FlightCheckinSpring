package com.example.flightreservationapp.flightreservationapplication.util;

import java.io.File;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailUtility {

	JavaMailSenderImpl javamailSender = new JavaMailSenderImpl();

	private JavaMailSender sender;

	public void sendItinerary(String toAddress, String filePath) {
		
		Properties props = new Properties();
		props.put("mail.properties.mail.smtp.starttls.enable", "true");
		props.put("mail.properties.mail.smtp.starttls.require", "true");
		props.put("mail.smtp.auth", "true");

		//set password and username
		
		javamailSender.setHost("smtp.gmail.com");
		javamailSender.setPort(587);
		
		javamailSender.setJavaMailProperties(props);
		
		sender = javamailSender;

		MimeMessage message = sender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject("Itinerary for your flight");

			messageHelper.setText("Please find your Itinerary attached.");
			messageHelper.addAttachment("Booking_Details", new File(filePath));

			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
