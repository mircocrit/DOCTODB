package com.javatechie.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Assistant{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String taxcode;
    private String address;
    private long telephone_no;
    private String levelspec;
    private Double salary;
    @OneToMany(mappedBy="assistant")
    private List<Appointment> appointments;

    public Assistant(String name, String surname, int age, String taxcode, String address, long telephone_no, String levelspec, Double salary, List<Appointment> appointments) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.taxcode = taxcode;
        this.address = address;
        this.telephone_no = telephone_no;
        this.levelspec = levelspec;
        this.salary = salary;
        this.appointments = appointments;
    }
}
