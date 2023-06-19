package com.example.vaccineManagement.Controller;

import com.example.vaccineManagement.DtoRepository.EmailDto;
import com.example.vaccineManagement.Models.User;
import com.example.vaccineManagement.Services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @PostMapping("/add_user")
    public ResponseEntity<String> addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>("user added successfully", HttpStatus.OK);
    }
    @GetMapping("/getVaccinationDate")
    public ResponseEntity<Date> getVaccinationDate(@RequestParam int userId){
        Date date = userService.getVaccinationDate(userId);
        return new ResponseEntity<>(date, HttpStatus.OK);
    }
    @PutMapping("/updateEmail")
    public ResponseEntity<String> updateEmail(@RequestBody EmailDto emailrequestDto){
        userService.updateEmail(emailrequestDto);
        return new ResponseEntity<>("Old email has been updated to new "+ emailrequestDto.getEmail(), HttpStatus.OK);
    }
    @GetMapping("/getUserByEmail")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email){
        User user = userService.getUserByEmail(email);
        if(user != null)
            return new ResponseEntity<>(user, HttpStatus.OK);
        else
            return new ResponseEntity<>("please enter a valid email id", HttpStatus.NOT_FOUND);
    }
}
