package com.example.vaccineManagement.Controller;

import com.example.vaccineManagement.DtoRepository.AppointmentDto;
import com.example.vaccineManagement.Services.Impl.AppointmentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentImpl appointmentService;
    @PostMapping("/addAppointment")
    public ResponseEntity<String> bookAppoinement(@RequestBody AppointmentDto appointment) {
        try {
            appointmentService.bookAppointMent(appointment);
            return new ResponseEntity<>("appointment taken Successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
       }
    }
}
