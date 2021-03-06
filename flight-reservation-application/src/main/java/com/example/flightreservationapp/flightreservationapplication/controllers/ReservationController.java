package com.example.flightreservationapp.flightreservationapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightreservationapp.flightreservationapplication.entities.Reservation;
import com.example.flightreservationapp.flightreservationapplication.models.CheckInRequestModel;
import com.example.flightreservationapp.flightreservationapplication.models.ReservationRequest;
import com.example.flightreservationapp.flightreservationapplication.services.ReservationService;

@RestController
@CrossOrigin
public class ReservationController {

	@Autowired
	public ReservationService reservationService;
	
	@RequestMapping(value="/api/reservation/reserveFlight",method=RequestMethod.POST)
	public Reservation reserveFlight(@RequestBody ReservationRequest reservationRequest) {
		Reservation reservation = reservationService.bookFlight(reservationRequest); 
		return reservation;
	}
	
	
	
	
	
}
