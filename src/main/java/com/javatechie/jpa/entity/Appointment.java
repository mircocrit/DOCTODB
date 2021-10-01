package com.javatechie.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date plannedatetime;
    @Temporal(TemporalType.DATE)
    private Date actualdatetime;
    private double price;
    private double outcome;
    @ManyToOne
    @JoinColumn(name="assistant", referencedColumnName="id", nullable=false)
    private Assistant assistant;
    @ManyToOne
    @JoinColumn(name="doctor", referencedColumnName="id", nullable=false)
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name="patient", referencedColumnName="id", nullable=false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name="service", referencedColumnName="id" , nullable=false)
    private Service service;


    public Appointment(Date plannedatetime, Date actualdatetime, double price, double outcome, Assistant assistant, Doctor doctor, Patient patient, Service service) {
        this.plannedatetime = plannedatetime;
        this.actualdatetime = actualdatetime;
        this.price = price;
        this.outcome = outcome;
        this.assistant = assistant;
        this.doctor = doctor;
        this.patient = patient;
        this.service = service;
    }
}
