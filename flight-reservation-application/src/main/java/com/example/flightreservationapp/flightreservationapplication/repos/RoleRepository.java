package com.example.flightreservationapp.flightreservationapplication.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flightreservationapp.flightreservationapplication.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
