package com.example.vaccineManagement.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Data
public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String centerName;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String location;
    private int doseCapacity;

    @OneToMany(mappedBy = "vaccinationCenter", cascade = CascadeType.ALL)
    private List<Doctor> doctorList = new ArrayList<>();

}
