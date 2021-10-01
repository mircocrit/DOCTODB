package com.javatechie.jpa.service;

import com.javatechie.jpa.entity.Appointment;
import com.javatechie.jpa.exception.AppointmentNotFoundException;
import com.javatechie.jpa.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment addAppointment(Appointment appointment) {
        //appointment.setId(UUID.randomUUID());
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment findAppointmentById(Long id) {
        return appointmentRepository.findAppointmentById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment by id " + id + " was not found"));
    }

    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id){
        appointmentRepository.deleteAppointmentById(id);
    }

}
