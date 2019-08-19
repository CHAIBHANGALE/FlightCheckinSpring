package com.example.flightcheckinapp.flightcheckinapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightreservationapp.flightreservationapplication.entities.Reservation;
import com.example.flightreservationapp.flightreservationapplication.models.CheckInRequestModel;
import com.example.flightreservationapp.flightreservationapplication.services.ReservationService;

@RestController
public class CheckinController {

	@Autowired
	public ReservationService reservationService;
	
	@RequestMapping(value="/api/checkin/findReservation",method=RequestMethod.GET)
	public Reservation reserveFlight(@RequestParam("reservation_id") Long id) {
		Reservation reservation = reservationService.getReservationDetails(id); 
		return reservation;
	}
	
	
	@RequestMapping(value="/api/checkin/updateReservation",method=RequestMethod.POST)
	public Reservation updateReservation(@RequestBody CheckInRequestModel request) {
		Reservation reservation = reservationService.updateReservation(request);
		return reservation;
	}
	
	
}
