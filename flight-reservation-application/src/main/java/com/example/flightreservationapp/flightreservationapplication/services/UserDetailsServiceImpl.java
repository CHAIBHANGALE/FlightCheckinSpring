package com.example.flightreservationapp.flightreservationapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.flightreservationapp.flightreservationapplication.entities.User;
import com.example.flightreservationapp.flightreservationapplication.repos.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username);
		
		if(user == null) {
			return null;
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),true, true, true, true, user.getRoles());
	}

}
