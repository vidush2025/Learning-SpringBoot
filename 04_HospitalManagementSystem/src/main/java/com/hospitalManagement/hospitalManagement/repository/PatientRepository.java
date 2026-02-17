package com.hospitalManagement.hospitalManagement.repository;


import com.hospitalManagement.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
