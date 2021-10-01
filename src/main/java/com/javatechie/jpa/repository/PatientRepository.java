package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    void deletePatientById(Long id);
    Optional<Patient> findPatientById(Long id);

}
