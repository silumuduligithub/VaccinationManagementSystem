package com.example.vaccineManagement.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Table
@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date appointmentDate;
    private LocalTime appointmentTime;

    @ManyToOne
    @JoinColumn
    Doctor doctor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    User user;
}
