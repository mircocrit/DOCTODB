package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    void deleteAppointmentById(Long id);
    Optional<Appointment> findAppointmentById(Long id);

}
