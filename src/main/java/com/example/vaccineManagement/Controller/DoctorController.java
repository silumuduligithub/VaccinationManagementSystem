package com.example.vaccineManagement.Controller;

import com.example.vaccineManagement.DtoRepository.DoctorAssociatedDto;
import com.example.vaccineManagement.Models.Doctor;
import com.example.vaccineManagement.Services.Impl.DoctorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorImpl doctorService;
    @PostMapping("/addDoctor")
    public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor){
        doctorService.addDoctor(doctor);
        return new ResponseEntity<>("doctor added successfully", HttpStatus.OK);
    }
    @PostMapping("/associatedDoctor")
    public ResponseEntity<String> associatedDoctor(@RequestBody DoctorAssociatedDto doctorAssociatedDto){
        try{
            doctorService.associatedDoctor(doctorAssociatedDto);
            return new ResponseEntity<>("doctorAssociated with the vaccinationCenter successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }
    @GetMapping("/getAllTheDoctorsAbove10Appointments")
    public ResponseEntity<List<Doctor>> getAllTheDoctorsAbove10Appointments(){
        List<Doctor> doctors = doctorService.getAllTheDoctorsAbove10Appointments();
        return  new ResponseEntity<>(doctors, HttpStatus.OK);
    }
    @GetMapping("/getmaleDoctorAgeAbove40")
    public ResponseEntity<List<Doctor>> maleDoctorAgeAboveFourty(){
        List<Doctor> doctors = doctorService.getAllMaleDoctorAgeAboveFourty();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
    @GetMapping("/ratioOfMaleAndFemaleDoctor")
    public ResponseEntity<Float> ratioOfMaleAndFemaleDoctor(){
        float ratio = doctorService.ratioOfMaleAndFemaleDoctor();
        return new ResponseEntity<>(ratio, HttpStatus.OK);
    }

}
