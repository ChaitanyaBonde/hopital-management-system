package com.hospitalmanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hospitalmanagement.entity.user;
import com.hospitalmanagement.repository.userrepo;

@Service
public class customeuserdetailservice implements UserDetailsService {
	
	
	@Autowired
	private userrepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	user user = repo.findByusername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("user not found"); 
		}
		UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
		
		builder.username(user.getUsername());
		builder.password(user.getPassword());
		builder.roles(user.getRole());
		return builder.build();
	}

}
