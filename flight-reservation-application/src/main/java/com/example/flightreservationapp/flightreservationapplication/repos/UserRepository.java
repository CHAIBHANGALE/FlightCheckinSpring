package com.example.flightreservationapp.flightreservationapplication.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.flightreservationapp.flightreservationapplication.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
