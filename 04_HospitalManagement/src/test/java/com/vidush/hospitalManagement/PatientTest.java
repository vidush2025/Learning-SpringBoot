package com.vidush.hospitalManagement;

import com.vidush.hospitalManagement.entity.Patient;
import com.vidush.hospitalManagement.repository.PatientRepository;
import com.vidush.hospitalManagement.service.PatientService;
import com.vidush.hospitalManagement.type.BloodGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patients = patientRepository.findAll();

        System.out.println("Patients:" + patients);
    }

    @Test
    public void testTransactionMethod(){
//        Patient p1 = patientService.getPatient(1L);
//        Patient p1 = patientRepository.findByEmail("sneha.gupta@example.com");
//        List<Patient> patients = patientRepository.findByDobBetween(
//                LocalDate.parse("1998-01-01"),
//                LocalDate.parse("2000-12-31")
//        );

//        List<Patient> patients = patientRepository.findByBloodGroup(BloodGroup.A_POSITIVE);

        List<Object[]> bgList = patientRepository.groupByBloodGroup();
        for(Object[] bGroup: bgList){
            System.out.println(bGroup[0] + ": " + bGroup[1]);
        }

//        System.out.println(patients.size() + " Patients Found:" + patients);

    }
}
