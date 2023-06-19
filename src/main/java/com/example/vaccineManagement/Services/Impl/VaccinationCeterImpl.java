package com.example.vaccineManagement.Services.Impl;

import com.example.vaccineManagement.Enums.Gender;
import com.example.vaccineManagement.Exceptions.CenterNotFound;
import com.example.vaccineManagement.Models.Doctor;
import com.example.vaccineManagement.Models.VaccinationCenter;
import com.example.vaccineManagement.Repository.VaccinationCeterRepository;
import com.example.vaccineManagement.Services.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VaccinationCeterImpl implements VaccinationCenterService {
    @Autowired
    VaccinationCeterRepository vaccinationCeterRepository;

    @Override
    public void addVaccinationCenter(VaccinationCenter vaccinationCenter) {
        vaccinationCeterRepository.save(vaccinationCenter);
    }
    @Override
    public List<Doctor> doctorsAtParticularCenter(int centerId) throws CenterNotFound{
        Optional<VaccinationCenter> vaccinationCenterOptional= vaccinationCeterRepository.findById(centerId);
        if(vaccinationCenterOptional.isEmpty()){
            throw new CenterNotFound("enter a valid center id");
        }
        VaccinationCenter vaccinationCenter = vaccinationCenterOptional.get();
        return vaccinationCenter.getDoctorList();
    }

    public List<Doctor> listOfFemaleDoctors(List<Doctor> doctors){
        List<Doctor> femaleDoctors = new ArrayList<>();
        for(Doctor doctor : doctors){
            if(doctor.getGender().equals(Gender.FEMALE))femaleDoctors.add(doctor);
        }
        return femaleDoctors;
    }

    public List<Doctor> listOfMaleDoctors(List<Doctor> doctors){
        List<Doctor> maleDoctors = new ArrayList<>();
        for(Doctor doctor : doctors){
            if(doctor.getGender().equals(Gender.MALE))maleDoctors.add(doctor);
        }
        return maleDoctors;
    }
    public List<Doctor> maleDoctorsAbove40(List<Doctor> doctors) {
        List<Doctor> doctorListAgeAbove40 = new ArrayList<>();
        for(Doctor doctor : doctors){
            if(doctor.getAge() > 40){
                doctorListAgeAbove40.add(doctor);
            }
        }
        return doctorListAgeAbove40;
    }
}
