package com.javatechie.jpa.service;

import com.javatechie.jpa.entity.Patient;
import com.javatechie.jpa.exception.PatientNotFoundException;
import com.javatechie.jpa.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        //appointment.setEmployeeCode(UUID.randomUUID().toString());
        return patientRepository.save(patient);
    }

    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    public Patient findPatientById(Long id) {
        return patientRepository.findPatientById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient by id " + id + " was not found"));
    }

    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id){
        patientRepository.deletePatientById(id);
    }
}
