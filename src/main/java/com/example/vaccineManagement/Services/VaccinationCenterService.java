package com.example.vaccineManagement.Services;

import com.example.vaccineManagement.Exceptions.CenterNotFound;
import com.example.vaccineManagement.Models.Doctor;
import com.example.vaccineManagement.Models.VaccinationCenter;

import java.util.List;

public interface VaccinationCenterService {
    public void addVaccinationCenter(VaccinationCenter vaccinationCenter);
    public List<Doctor> doctorsAtParticularCenter(int centerId) throws CenterNotFound;
    public List<Doctor> listOfFemaleDoctors(List<Doctor> doctors);
    public List<Doctor> listOfMaleDoctors(List<Doctor> doctors);
    public List<Doctor> maleDoctorsAbove40(List<Doctor> doctors);
}
