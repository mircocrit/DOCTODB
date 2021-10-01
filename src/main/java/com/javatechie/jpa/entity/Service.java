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
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer name;
    private String description;
    private String type;
    private String cost;

    @OneToMany(mappedBy="service")
    private List<Appointment> service;

    public Service(Integer name, String description, String type, String cost, List<Appointment> service) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.cost = cost;
        this.service = service;
    }
}
