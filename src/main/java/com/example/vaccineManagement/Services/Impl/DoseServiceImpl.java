package com.example.vaccineManagement.Services.Impl;

import com.example.vaccineManagement.Models.Dose;
import com.example.vaccineManagement.Models.User;
import com.example.vaccineManagement.Repository.DoseRepository;
import com.example.vaccineManagement.Repository.UserRepository;
import com.example.vaccineManagement.Services.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoseServiceImpl implements DoseService {
    @Autowired
    DoseRepository doseRepository;
    @Autowired
    UserRepository userRepository;
    public void giveDose(int userId, int doseId) {
        User user = userRepository.findById(userId).get();
        Dose dose = new Dose();
        dose.setId(doseId);
        dose.setUser(user);
        user.setDose(dose);
        // if save it in parent then it internally automatically save the child;
        userRepository.save(user);
    }
}
