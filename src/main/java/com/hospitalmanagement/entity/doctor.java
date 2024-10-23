package com.hospitalmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Doctor_id;
	private String name;
	private String Speciality;
	private String Shift;
}
