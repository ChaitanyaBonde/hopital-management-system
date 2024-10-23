package com.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmanagement.entity.patient;

public interface patientrepo extends JpaRepository<patient, Integer> {

}
