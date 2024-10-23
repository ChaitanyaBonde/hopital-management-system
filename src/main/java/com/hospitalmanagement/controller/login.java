package com.hospitalmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class login {

	@GetMapping("/login")
	public String login() {
		 return "Please login with your credentials";
	}
}
