package com.hospitalManagement.hospitalManagement;

import com.hospitalManagement.hospitalManagement.entity.Patient;
import com.hospitalManagement.hospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;


    @Test
    public void testPatientRepository(){
        List<Patient> patients = patientRepository.findAll();
        System.out.println("List of Patients:" + patients);
    }
}
