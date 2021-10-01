package com.javatechie.jpa.service;

import com.javatechie.jpa.entity.Doctor;
import com.javatechie.jpa.entity.Patient;
import com.javatechie.jpa.exception.DoctorNotFoundException;
import com.javatechie.jpa.exception.PatientNotFoundException;
import com.javatechie.jpa.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor addDoctor(Doctor doctor) {
        //appointment.setEmployeeCode(UUID.randomUUID().toString());
        return doctorRepository.save(doctor);
    }

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor findDoctorById(Long id) {
        return doctorRepository.findDoctorById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor by id " + id + " was not found"));
    }

    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id){
        doctorRepository.deleteDoctorById(id);
    }
}
