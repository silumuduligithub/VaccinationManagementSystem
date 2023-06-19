package com.example.vaccineManagement.Services;

import com.example.vaccineManagement.DtoRepository.DoctorAssociatedDto;
import com.example.vaccineManagement.Exceptions.CenterNotFound;
import com.example.vaccineManagement.Exceptions.DoctorNotFound;
import com.example.vaccineManagement.Models.Doctor;

import java.util.List;

public interface DoctorService {
    public void addDoctor(Doctor doctor);
    public void associatedDoctor(DoctorAssociatedDto doctorAssociatedDto)throws DoctorNotFound, CenterNotFound;
    public List<Doctor> getAllTheDoctorsAbove10Appointments();
    public List<Doctor> getAllMaleDoctorAgeAboveFourty();
    public float ratioOfMaleAndFemaleDoctor();
}
