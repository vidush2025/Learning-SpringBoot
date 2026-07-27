package com.vidush.hospitalManagement.entity;

import com.vidush.hospitalManagement.type.BloodGroup;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Setter
@Getter
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "patientEmail", columnNames = {"email"})
        },
        indexes = {
                @Index(name = "patientDob", columnList = "dob")
        }
)
public class  Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(nullable = false)
    private String email;

    private String gender;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToOne
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    List<Appointment> appointments;
}
