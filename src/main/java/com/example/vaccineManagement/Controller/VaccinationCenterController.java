package com.example.vaccineManagement.Controller;

import com.example.vaccineManagement.Models.Doctor;
import com.example.vaccineManagement.Models.VaccinationCenter;
import com.example.vaccineManagement.Services.Impl.VaccinationCeterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class VaccinationCenterController {
    @Autowired
    VaccinationCeterImpl vaccinationCeterService;
    public ResponseEntity<String> addVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter){
        vaccinationCeterService.addVaccinationCenter(vaccinationCenter);
        return new ResponseEntity<>("VaccinationCenter added successfully", HttpStatus.OK);
    }
    @GetMapping("listOfDoctorsAtAParticularVaccinationCenter")
    public ResponseEntity<?> doctorsAtParticularCenter(@RequestParam int centerId){
        try {
            List<Doctor> doctors = vaccinationCeterService.doctorsAtParticularCenter(centerId);
            return new ResponseEntity<>(doctors, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/listOfFemaleDoctors")
    public ResponseEntity<?> listOfFemaleDoctors(@RequestParam int centerId){
        try {
            List<Doctor> doctors = vaccinationCeterService.doctorsAtParticularCenter(centerId);
            List<Doctor> femaleDoctors = vaccinationCeterService.listOfFemaleDoctors(doctors);
            return new ResponseEntity<>(femaleDoctors, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/listOfMaleDoctors")
    public ResponseEntity<?> listOfMaleDoctors(@RequestParam int centerId){
        try {
            List<Doctor> Doctors = vaccinationCeterService.doctorsAtParticularCenter(centerId);
            List<Doctor> maleDoctors = vaccinationCeterService.listOfMaleDoctors(Doctors);
            return new ResponseEntity<>(maleDoctors, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/maleDoctorsAbove40")
    public ResponseEntity<?> maleDoctorsAbove40(@RequestParam int  centerId){
        try {
            List<Doctor> doctors = vaccinationCeterService.doctorsAtParticularCenter(centerId);
            List<Doctor> maleDoctors = vaccinationCeterService.listOfMaleDoctors(doctors);
            List<Doctor> doctorsAbove40 =  vaccinationCeterService.maleDoctorsAbove40(maleDoctors);
            return new ResponseEntity<>(doctorsAbove40, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
