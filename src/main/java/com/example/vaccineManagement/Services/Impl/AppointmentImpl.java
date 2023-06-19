package com.example.vaccineManagement.Services.Impl;


import com.example.vaccineManagement.Exceptions.DoctorNotFound;
import com.example.vaccineManagement.Exceptions.UserNotFound;
import com.example.vaccineManagement.DtoRepository.AppointmentDto;
import com.example.vaccineManagement.Models.Appointment;
import com.example.vaccineManagement.Models.Doctor;
import com.example.vaccineManagement.Models.User;
import com.example.vaccineManagement.Repository.AppointmentRepository;
import com.example.vaccineManagement.Repository.DoctorRepository;
import com.example.vaccineManagement.Repository.UserRepository;
import com.example.vaccineManagement.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentImpl implements AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    JavaMailSender javaMailSender;

   @Override
    public void bookAppointMent(AppointmentDto appointmentReqDto) throws UserNotFound, DoctorNotFound{
        Optional<Doctor> doctorOptional = doctorRepository.findById(appointmentReqDto.getDocId());
        if(doctorOptional.isEmpty()){
            throw  new DoctorNotFound("doctorNotFound");
        }
        Optional<User> userOptional = userRepository.findById(appointmentReqDto.getUserId());
        if(userOptional.isEmpty()){
            throw new UserNotFound("user not found");
        }
        Doctor doctor = doctorOptional.get();
        User user = userOptional.get();
       Appointment appointment = new Appointment();
       appointment.setUser(user);
       appointment.setDoctor(doctor);
       appointment.setAppointmentDate(appointmentReqDto.getDate());
       appointment.setAppointmentTime(appointmentReqDto.getTime());
       appointmentRepository.save(appointment);
       doctor.getAppointmentList().add(appointment);
       doctorRepository.save(doctor);
       user.getAppointmentList().add(appointment);
       userRepository.save(user);


       // send email to sender
       String body = "Hi!"+user.getName()+"\n"+
       "you have successfully booked an appointment on" + appointment.getAppointmentDate() + "at time" + appointment.getAppointmentTime() + "\n"+
       "your doctor is" + appointment.getDoctor().getName() +"\n"+
       "please reach at " + doctor.getVaccinationCenter() + "\n" +
       "mask is Mandatory";

       SimpleMailMessage mailMessage = new SimpleMailMessage();
       mailMessage.setFrom("dummyMale@gmail.com");
       mailMessage.setTo(user.getEmail());
       mailMessage.setSubject("Appointment confirmer !");
       mailMessage.setText(body);
       javaMailSender.send(mailMessage);
    }
}
