package com.example.flightreservationapp.flightreservationapplication.models;

import com.example.flightreservationapp.flightreservationapplication.entities.Passenger;

public class ReservationRequest {

	public Long flightId;
	public Passenger passenger;
	
	
	public ReservationRequest() {
		passenger = new Passenger();
	}
	public Long getFlightId() {
		return flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	
}
