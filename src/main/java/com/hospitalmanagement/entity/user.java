package com.hospitalmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class user {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String username;
	private String password;
	private String role;
	
}
