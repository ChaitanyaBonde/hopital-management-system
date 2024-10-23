package com.hospitalmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.persister.entity.EntityNameUse.UseKind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmanagement.entity.user;
import com.hospitalmanagement.service.userservice;

@RestController
@RequestMapping("/user")
public class usercontroller {

	@Autowired
	private userservice service;
	
	@PostMapping
	public user save(@RequestBody user user) {
		return service.save(user);
	}
	
	@GetMapping
	public List<user> find() {
		return service.getall();
	}
	
	@GetMapping("/{id}")
	public Optional<user> findid(@PathVariable("id") int id) {
		return service.getbyid(id);
	}
	
	@PutMapping("/{id}")
	public user update(@PathVariable("id") int id, @RequestBody user user) {
		return service.update(id,user);
	}
	
	@DeleteMapping("/{id}")
	public String delte(@PathVariable("id") int id) {
		return service.delbyid(id);
	}
	
}
