package com.vidush.hospitalManagement.repository;

import com.vidush.hospitalManagement.entity.Patient;
import com.vidush.hospitalManagement.type.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);
    Patient findByEmail(String email);
    List<Patient> findByDobBetween(LocalDate start, LocalDate end);

    @Query("SELECT p FROM Patient p " +
            "WHERE p.bloodGroup = :bloodGroup"
    )
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroup bg);

    @Query(
            "SELECT p.bloodGroup, COUNT(p) " +
                    "FROM Patient p " +
                    "GROUP BY p.bloodGroup"
    )
    List<Object[]> groupByBloodGroup();
}
