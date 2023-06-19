package com.example.vaccineManagement.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Table
@Entity
@Data
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String doesId;
    @CreationTimestamp
    private Date vaccinationDate;

    @JsonIgnore
    @OneToOne
    @JoinColumn
    User user;


}
