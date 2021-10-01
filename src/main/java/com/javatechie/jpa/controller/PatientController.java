package com.javatechie.jpa.controller;

import com.javatechie.jpa.entity.Appointment;
import com.javatechie.jpa.entity.Patient;
import com.javatechie.jpa.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients () {
        List<Patient> patients = patientService.findAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Patient> getPatientById (@PathVariable("id") Long id) {
        Patient patient = patientService.findPatientById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient newPatient = patientService.addPatient(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
        Patient updatePatient = patientService.updatePatient(patient);
        return new ResponseEntity<>(updatePatient, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
