package com.example.flightreservationapp.flightreservationapplication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.example.flightreservationapp.flightreservationapplication.models.BaseResponseModel;
import com.example.flightreservationapp.flightreservationapplication.models.RegisterUserResponseModel;

@Configuration
public class AppConfig {

	@Bean
	public BaseResponseModel getBaseResponseModel() {
		return new BaseResponseModel();
	}
	
	@Bean
	@Primary
	public RegisterUserResponseModel getRegisterUserResponseModel() {
		return new RegisterUserResponseModel();
	}
	
	
	
	
	
}
