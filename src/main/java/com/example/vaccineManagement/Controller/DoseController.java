package com.example.vaccineManagement.Controller;

import com.example.vaccineManagement.Services.Impl.DoseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseServiceImpl doseService;
    @PostMapping("/give_dose")
    public ResponseEntity<String> giveDose(int userId, int doseId){
        doseService.giveDose(userId, doseId);
        return new ResponseEntity<>("user takes the dose", HttpStatus.OK);
    }
}
