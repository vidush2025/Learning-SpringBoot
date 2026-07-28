package com.vidush.hospitalManagement;

import com.vidush.hospitalManagement.entity.Insurance;
import com.vidush.hospitalManagement.entity.Patient;
import com.vidush.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private  InsuranceService insuranceService;

    @Test
    public void insuranceTest(){
        Insurance insurance = Insurance.builder()
                .policyNumber("UCO_1234")
                .provider("UCO")
                .validUntil(LocalDate.of(2030, 12, 12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 4L);

        System.out.println("patient:" + patient);
    }
}
