package com.example.vaccineManagement.Services.Impl;

import com.example.vaccineManagement.DtoRepository.EmailDto;
import com.example.vaccineManagement.Exceptions.UserNotFound;
import com.example.vaccineManagement.Models.User;
import com.example.vaccineManagement.Repository.DoctorRepository;
import com.example.vaccineManagement.Repository.UserRepository;
import com.example.vaccineManagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public void addUser(User user) {
       userRepository.save(user);
    }

    @Override
    public Date getVaccinationDate(int userId) {
        User user = userRepository.findById(userId).get();
        return user.getDose().getVaccinationDate();
    }

    public void updateEmail(EmailDto emailrequestDto) {
        User user = userRepository.findById(emailrequestDto.getUser_Id()).get();
        user.setEmail(emailrequestDto.getEmail());
        userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        List<User> users = userRepository.findAll();
        for(User user : users){
            if(user.getEmail().equals(email))return user;
        }
        return null;
    }
}
