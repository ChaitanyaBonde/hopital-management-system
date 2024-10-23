package com.hospitalmanagement.controller;

import java.util.List;
import java.util.Optional;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmanagement.entity.doctor;
import com.hospitalmanagement.service.doctorservice;

@RestController
@RequestMapping("/doctor")
public class doctorcontroller {

	@Autowired
	private doctorservice service;
	
	@PostMapping
	public doctor savedoctor(@RequestBody doctor doc) {
		return service.savedata(doc);
	}
	
	@GetMapping
	public List<doctor> getall(){
		return service.findall();
	}
	
	@GetMapping("/{id}")
	public Optional<doctor> getbyid(@PathVariable("id") int id) {
		return service.findbyid(id);
	}
	
	@PutMapping("/{id}")
	public doctor update(@PathVariable("id") int id, @RequestBody doctor doc) {
		return service.updatebyid(id, doc);
	}
	
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		return service.delbyid(id);
	}
	
}
