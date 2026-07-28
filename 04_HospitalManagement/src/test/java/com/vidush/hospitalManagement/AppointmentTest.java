package com.vidush.hospitalManagement;

import com.vidush.hospitalManagement.entity.Appointment;
import com.vidush.hospitalManagement.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static java.util.stream.Stream.builder;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 07, 1, 14, 0))
                .reason("Cancer Diagnosis")
                .build();
        Appointment newAppointment = appointmentService.createAppointment(appointment, 1L, 2L);
        System.out.println(newAppointment);
    }
}
