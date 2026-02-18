package com.hospitalManagement.hospitalManagement;

import com.hospitalManagement.hospitalManagement.entity.Patient;
import com.hospitalManagement.hospitalManagement.repository.PatientRepository;
import com.hospitalManagement.hospitalManagement.sevice.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService ps;


    @Test
    public void testPatientRepository(){
        List<Patient> patients = patientRepository.findAll();
        System.out.println("List of Patients:" + patients);
    }

    @Test
    public void testTransactionMethods(){
        Long id = 1L;
        Patient patient =  ps.getPatientById(id);
        System.out.println("patient found:" + patient);
    }
}
