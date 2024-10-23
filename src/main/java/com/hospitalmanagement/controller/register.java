package com.hospitalmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmanagement.entity.user;
import com.hospitalmanagement.service.userservice;

@RestController
@RequestMapping("/register")
public class register {

	@Autowired
	private userservice service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping
	public String register(@RequestBody user user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		service.save(user);
		 return "User registered successfully!";
		
	}
}
