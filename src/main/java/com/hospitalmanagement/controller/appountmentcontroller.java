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

import com.hospitalmanagement.entity.appoinment;
import com.hospitalmanagement.service.appoinmentservice;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/appoinment")
public class appountmentcontroller {

	@Autowired
	private appoinmentservice service;
	
	
	@PostMapping
	public appoinment save(@RequestBody appoinment app) {
		return service.savedata(app);
	}
	
	@GetMapping
	public List<appoinment> geall(){
		return service.findall();
	}
	
	@GetMapping("/{id}")
	public Optional<appoinment> getbyid(@PathVariable("id") int id){
		return service.findbyid(id);
	}
	
	@PutMapping("/{id}")
	public appoinment update (@PathVariable ("id") int id , @RequestBody appoinment app) {
		
		return service.updatebyid( id, app);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		return service.delbyid(id);
	}
}
