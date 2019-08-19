package com.example.flightreservationapp.flightreservationapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.flightreservationapp.flightreservationapplication.entities.User;
import com.example.flightreservationapp.flightreservationapplication.models.BaseResponseModel;
import com.example.flightreservationapp.flightreservationapplication.models.RegisterUserResponseModel;
import com.example.flightreservationapp.flightreservationapplication.repos.UserRepository;
import com.example.flightreservationapp.flightreservationapplication.services.SecurityService;
import com.example.flightreservationapp.flightreservationapplication.util.ResponseConstants;

@RestController
@ComponentScan("com.example.flightreservationapp.flightreservationapplication.configuration")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private BaseResponseModel baseResponseModel;

	@Autowired
	private RegisterUserResponseModel userModel;

	
	@RequestMapping(value = "/api/user/registerUser", method = RequestMethod.POST)
	public RegisterUserResponseModel RegisterUser(@RequestBody User user) {

		try {
			user.setPassword(encoder.encode(user.getPassword()));
			userRepository.save(user);

			userModel.setRegisteredUserInfo(user);
			userModel.status = ResponseConstants.SUCCESS;
			userModel.message = "Registration Successful";

		} catch (Exception e) {
			userModel.status = ResponseConstants.SYSTEM_ERROR;
			userModel.message = "Something went wrong!";
			e.printStackTrace();
		}

		return userModel;
	}

	@RequestMapping(value = "/api/user/login", method = RequestMethod.POST)
	public BaseResponseModel login(@RequestBody User user) {

		try {
			boolean loginResponse = securityService.login(user.getEmail(), user.getPassword());

			if (loginResponse) {
				baseResponseModel.status = ResponseConstants.SUCCESS;
				baseResponseModel.message = "Logged in Successfully";
			} else {
				baseResponseModel.status = ResponseConstants.INVALID_USER;
				baseResponseModel.message = "Invalid UserName or Password . Please Try Again!";
			}
		} catch (BadCredentialsException e) {
			baseResponseModel.status = ResponseConstants.INVALID_USER;
			baseResponseModel.message = "Invalid UserName or Password . Please Try Again!";
		}

		catch (Exception e) {
			baseResponseModel.status = ResponseConstants.SYSTEM_ERROR;
			baseResponseModel.message = "Something went wrong!";
			e.printStackTrace();
		}
		return baseResponseModel;
	}

}
