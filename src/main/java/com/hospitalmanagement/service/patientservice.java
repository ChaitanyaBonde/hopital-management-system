package com.hospitalmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagement.entity.patient;
import com.hospitalmanagement.repository.patientrepo;

@Service
public class patientservice {

	@Autowired
	private patientrepo repo;

	public patient save(patient pat) {
	
		return repo.save(pat);
	}

	public List<patient> findall() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<patient> findbyid(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public patient update(int id, patient pat) {
		patient uppat = repo.findById(id).get();
		if(uppat != null) {
			uppat.setAge(pat.getAge());
			uppat.setName(pat.getName());
			return repo.save(uppat);
		}
		return null;
	}

	public String delbyid(int id) {
		// TODO Auto-ge
		repo.deleteById(id);
		return "deleted";
	}
}
