package com.example.vaccineManagement.Repository;

import com.example.vaccineManagement.Models.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose, Integer> {
}
