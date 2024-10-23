package com.hospitalmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmanagement.entity.user;

public interface userrepo extends JpaRepository<user, Integer> {

	user findByusername(String username);

}
