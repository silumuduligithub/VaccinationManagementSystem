package com.example.vaccineManagement.Services;

import com.example.vaccineManagement.DtoRepository.EmailDto;
import com.example.vaccineManagement.Models.User;

import java.util.Date;

public interface UserService {
    public void addUser(User user);
    public Date getVaccinationDate(int userId);
    public void updateEmail(EmailDto emailrequestDto);
    public User getUserByEmail(String email);
}
