package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>  {
    void deleteDoctorById(Long id);
    Optional<Doctor> findDoctorById(Long id);
}
