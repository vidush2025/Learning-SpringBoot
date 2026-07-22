package com.vidush.hospitalManagement.service;

import com.vidush.hospitalManagement.entity.Patient;
import com.vidush.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatient(Long id){
        Patient p1 = patientRepository.findById(id).orElseThrow();
        return p1;
    }
}
