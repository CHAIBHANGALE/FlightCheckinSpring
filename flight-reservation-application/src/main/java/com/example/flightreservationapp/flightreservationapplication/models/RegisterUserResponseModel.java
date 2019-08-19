package com.example.flightreservationapp.flightreservationapplication.models;

import com.example.flightreservationapp.flightreservationapplication.entities.User;

public class RegisterUserResponseModel extends BaseResponseModel{

	private User RegisteredUserInfo;

	public User getRegisteredUserInfo() {
		return RegisteredUserInfo;
	}

	public void setRegisteredUserInfo(User registeredUserInfo) {
		RegisteredUserInfo = registeredUserInfo;
	}
	
	
	
}
