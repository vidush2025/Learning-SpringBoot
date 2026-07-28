package com.vidush.hospitalManagement.service;

import com.vidush.hospitalManagement.entity.Appointment;
import com.vidush.hospitalManagement.entity.Doctor;
import com.vidush.hospitalManagement.entity.Patient;
import com.vidush.hospitalManagement.repository.AppointmentRepository;
import com.vidush.hospitalManagement.repository.DoctorRepository;
import com.vidush.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createAppointment(@NonNull Appointment appointment, Long docId, Long patientId){
        Doctor doc = doctorRepository.findById(docId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null)
            throw new IllegalArgumentException("Appointment Id should not be passed.");

        appointment.setPatient(patient);
        appointment.setDoctor(doc);

        patient.getAppointments().add(appointment);

        appointmentRepository.save(appointment);
        return appointment;
    }
}
