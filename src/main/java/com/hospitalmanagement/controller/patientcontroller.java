package com.hospitalmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmanagement.entity.patient;
import com.hospitalmanagement.service.patientservice;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/patient")
public class patientcontroller {

	@Autowired
	private patientservice service;
	
	@PostMapping
	public patient Save(@RequestBody patient pat) {
		return service.save(pat);
	}
	
	@GetMapping
	public List<patient> getall(){
	 return	service.findall();
	}
	
	@GetMapping("/{id}")
	public Optional<patient> getyid(@PathVariable("id") int id){
		return service.findbyid(id);
	}
	
	@PutMapping("/{id}")
	public patient putMethodName(@PathVariable("id") int id, @RequestBody patient pat) {
	
		return service.update(id,pat);
	}
	
	@DeleteMapping("/{id}")
	public String delbyid(@PathVariable("id") int id) {
		return service.delbyid(id);
	}
}
