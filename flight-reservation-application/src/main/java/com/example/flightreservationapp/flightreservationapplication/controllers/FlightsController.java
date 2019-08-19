package com.example.flightreservationapp.flightreservationapplication.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.flightreservationapp.flightreservationapplication.entities.Flight;
import com.example.flightreservationapp.flightreservationapplication.repos.FlightRepository;

@RestController
public class FlightsController {


	@Autowired
	private FlightRepository flightsRepository;
	
	@RequestMapping(value="/api/flights/findFlights",method=RequestMethod.GET)
	public List<Flight> findFlights(@RequestParam("from") String from,@RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate) {
		
		List<Flight> flights =  flightsRepository.findFlights(from,to,departureDate);
		//List<Flight> flights =flightsRepository.findByDepartureCity(from);
		return flights;
	}
	
	
	@RequestMapping(value="/api/flights/addFlight",method = RequestMethod.POST)
	public String addFlight() {
		
		return null;
	}
	
	
//	@RequestMapping(value="/api/reservation/getInfoOfFlight",method=RequestMethod.GET)
//	public Flight getInfoOfFlight(@RequestParam("flightId") Long flightId) {
//		
//		Flight flight = flightsRepository.findOne(flightId);
//		
//		return flight;
//	}
//	
	
	
}
