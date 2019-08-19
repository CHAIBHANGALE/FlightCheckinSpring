package com.example.flightreservationapp.flightreservationapplication.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.flightreservationapp.flightreservationapplication.entities.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
