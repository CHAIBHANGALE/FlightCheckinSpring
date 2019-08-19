package com.example.flightreservationapp.flightreservationapplication.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flightreservationapp.flightreservationapplication.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
