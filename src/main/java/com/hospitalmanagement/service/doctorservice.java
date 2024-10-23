package com.hospitalmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagement.entity.appoinment;
import com.hospitalmanagement.entity.doctor;
import com.hospitalmanagement.repository.doctorrepo;

@Service
public class doctorservice {

	@Autowired
	private doctorrepo repo;
	public doctor savedata(doctor doc) {
		// TODO Auto-generated method stub
		return repo.save(doc);
	}

	public List<doctor> findall() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<doctor> findbyid(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public doctor updatebyid(int id, doctor doc) {
		doctor updoc = repo.findById(id).get();
		if(updoc != null) {
			updoc.setName(doc.getName());
			updoc.setShift(doc.getShift());
			updoc.setSpeciality(doc.getSpeciality());
			
			return repo.save(updoc);
		}
		return null;
	}

	public String delbyid(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "Deleted";
	}
	
}
