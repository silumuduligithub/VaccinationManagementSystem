package com.example.vaccineManagement.Services.Impl;

import com.example.vaccineManagement.DtoRepository.DoctorAssociatedDto;
import com.example.vaccineManagement.Enums.Gender;
import com.example.vaccineManagement.Exceptions.CenterNotFound;
import com.example.vaccineManagement.Exceptions.DoctorNotFound;
import com.example.vaccineManagement.Models.Doctor;
import com.example.vaccineManagement.Models.VaccinationCenter;
import com.example.vaccineManagement.Repository.DoctorRepository;
import com.example.vaccineManagement.Repository.VaccinationCeterRepository;
import com.example.vaccineManagement.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    VaccinationCeterRepository vaccinationCeterRepository;
    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public void associatedDoctor(DoctorAssociatedDto doctorAssociatedDto) throws DoctorNotFound, CenterNotFound{
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorAssociatedDto.getDoctorId());
        if(doctorOptional.isEmpty()){
            throw new DoctorNotFound("enter a valid doctor id");
        }
        Optional<VaccinationCenter> vaccinationCenterOptional = vaccinationCeterRepository.findById(doctorAssociatedDto.getCenterId());
        if(vaccinationCenterOptional.isEmpty()){
            throw new CenterNotFound("enter a valid ceter id");
        }
        Doctor doctor = doctorOptional.get();
        VaccinationCenter vaccinationCenter = vaccinationCenterOptional.get();
        vaccinationCenter.getDoctorList().add(doctor);
        doctor.setVaccinationCenter(vaccinationCenter);
        vaccinationCeterRepository.save(vaccinationCenter);
    }

    public List<Doctor> getAllTheDoctorsAbove10Appointments() {
       List<Doctor> doctorsList = doctorRepository.findAll();
       List<Doctor> doctorsAbove10Appointments = new ArrayList<>();
       for(Doctor doctor : doctorsList){
           if(doctor.getAppointmentList().size() >= 10){
               doctorsAbove10Appointments.add(doctor);
           }
       }
       return doctorsAbove10Appointments;
    }

    public List<Doctor> getAllMaleDoctorAgeAboveFourty() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<Doctor> doctorList = new ArrayList<>();
        for(Doctor doctor : doctors){
            if(doctor.getGender().equals(Gender.MALE) && doctor.getAge() > 40){
                doctorList.add(doctor);
            }
        }
        return doctorList;
    }

    public float ratioOfMaleAndFemaleDoctor() {
        List<Doctor> doctors = doctorRepository.findAll();
        int maleDoctors = 0, femaleDoctors = 0;
        for(Doctor doctor : doctors){
            if(doctor.getGender().equals(Gender.MALE)){
                maleDoctors++;
            }
            if(doctor.getGender().equals(Gender.FEMALE)){
                femaleDoctors++;
            }
        }
        return (float) maleDoctors / femaleDoctors;
    }
}
