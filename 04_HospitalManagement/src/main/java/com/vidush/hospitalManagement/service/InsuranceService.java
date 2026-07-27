package com.vidush.hospitalManagement.service;

import com.vidush.hospitalManagement.entity.Insurance;
import com.vidush.hospitalManagement.entity.Patient;
import com.vidush.hospitalManagement.repository.InsuranceRepository;
import com.vidush.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long id){
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("assignInsuranceToPatient: Patient not found with id: " + id)
        );

        patient.setInsurance(insurance);
        insurance.setPatient(patient); //bidirectional maintenance (not a good practice of 2 source of truths, just for learning rn)

        return patient;
    }
}
