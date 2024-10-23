package com.hospitalmanagement.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.model.jdbc.UpsertOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagement.entity.user;
import com.hospitalmanagement.repository.userrepo;

@Service
public class userservice {

	@Autowired
	private userrepo repo;

	public user save(user user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	public List<user> getall() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<user> getbyid(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public user update(int id, user user) {
		user upuser = repo.findById(id).get();
		if(upuser != null) {
			upuser.setPassword(user.getPassword());
			upuser.setRole(user.getRole());
			upuser.setUsername(user.getUsername());
			return repo.save(upuser);
		}
		return null;
	}

	public String delbyid(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "deleted";
	}
}
