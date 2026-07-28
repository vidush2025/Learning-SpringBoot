package com.vidush.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    // owner side
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false )
    private Patient patient;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Doctor doctor;
}
