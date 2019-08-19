package com.example.flightreservationapp.flightreservationapplication.services;

import com.example.flightreservationapp.flightreservationapplication.entities.Reservation;
import com.example.flightreservationapp.flightreservationapplication.models.CheckInRequestModel;
import com.example.flightreservationapp.flightreservationapplication.models.ReservationRequest;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
	public Reservation updateReservation(CheckInRequestModel request);
	public Reservation getReservationDetails(Long reservationId);
	
}
