package com.example.flightreservationapp.flightreservationapplication.services;

import java.io.File;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.flightreservationapp.flightreservationapplication.entities.Flight;
import com.example.flightreservationapp.flightreservationapplication.entities.Passenger;
import com.example.flightreservationapp.flightreservationapplication.entities.Reservation;
import com.example.flightreservationapp.flightreservationapplication.models.CheckInRequestModel;
import com.example.flightreservationapp.flightreservationapplication.models.ReservationRequest;
import com.example.flightreservationapp.flightreservationapplication.repos.FlightRepository;
import com.example.flightreservationapp.flightreservationapplication.repos.PassengerRepository;
import com.example.flightreservationapp.flightreservationapplication.repos.ReservationRepository;
import com.example.flightreservationapp.flightreservationapplication.util.EmailUtility;
import com.example.flightreservationapp.flightreservationapplication.util.pdfGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	public FlightRepository flightRepository;

	@Autowired
	public PassengerRepository passengerRepository;

	@Autowired
	public ReservationRepository reservationRepository;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		Reservation savedReservation = null;
		
		try {
			Long flightId = request.getFlightId();
			Optional<Flight> opflight = flightRepository.findById(flightId);

			Flight flight = null;

			if (opflight.isPresent()) {
				flight = opflight.get();
			} else {
				return null;
			}

			Passenger passenger = new Passenger();
			passenger.setFirstName(request.passenger.getFirstName());
			passenger.setMiddleName(request.passenger.getMiddleName());
			passenger.setLastName(request.passenger.getLastName());
			passenger.setEmail(request.passenger.getEmail());
			passenger.setPhone(request.passenger.getPhone());

			Passenger savedPassenger = passengerRepository.save(passenger);

			Reservation reservation = new Reservation();
			reservation.setPassenger(savedPassenger);
			reservation.setFlight(flight);
			reservation.setCheckedIn(false);
			savedReservation = reservationRepository.save(reservation);

			new pdfGenerator().generateItinerary(savedReservation, new File(".").getCanonicalPath() +"/" + savedPassenger.getId() + ".pdf");

			new EmailUtility().sendItinerary(request.passenger.getEmail(), new File(".").getCanonicalPath() +"/" + savedPassenger.getId() + ".pdf");

			return savedReservation;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return savedReservation;
	}

	@Override
	public Reservation updateReservation(CheckInRequestModel request) {

		Optional<Reservation> opReservation = reservationRepository.findById(request.reservationId);

		Reservation reservation = null;

		if (opReservation.isPresent()) {
			reservation = opReservation.get();
		}
		reservation.setNumberOfBags(request.noOfBags);
		reservation.setCheckedIn(true);
		reservation = reservationRepository.save(reservation);
		return reservation;
	}

	@Override
	public Reservation getReservationDetails(Long reservationId) {

		Optional<Reservation> opReservation = reservationRepository.findById(reservationId);

		if (opReservation.isPresent()) {
			return opReservation.get();
		}

		return null;
	}

}
