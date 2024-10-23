package com.hospitalmanagement.entity;

import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data

public class appoinment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int app_id;
	private LocalDateTime time;
	private String status;
	
	
	
	@ManyToOne
	private doctor doctor;
	
	@ManyToOne
	private patient patient;

}
