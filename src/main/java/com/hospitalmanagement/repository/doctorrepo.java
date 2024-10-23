package com.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmanagement.entity.doctor;

public interface doctorrepo extends JpaRepository<doctor, Integer> {

}
