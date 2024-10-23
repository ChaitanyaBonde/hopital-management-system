package com.hospitalmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagement.entity.appoinment;
import com.hospitalmanagement.repository.appoinmetrepo;

@Service
public class appoinmentservice {

	@Autowired
	private appoinmetrepo repo;

	public appoinment savedata(appoinment app) {
		// TODO Auto-generated method stub
		return repo.save(app);
	}

	public List<appoinment> findall() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<appoinment> findbyid(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public appoinment updatebyid(int id, appoinment app) {
		appoinment upap = repo.findById(id).get();
		if(upap != null) {
			upap.setDoctor(app.getDoctor());
			upap.setPatient(app.getPatient());
			upap.setStatus(app.getStatus());
			upap.setTime(app.getTime());
			
			return repo.save(upap);
		}
		return null;
	}

	public String delbyid(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "Deleted";
	}
}
