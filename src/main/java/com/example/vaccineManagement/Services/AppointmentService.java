package com.example.vaccineManagement.Services;

import com.example.vaccineManagement.DtoRepository.AppointmentDto;
import com.example.vaccineManagement.Exceptions.DoctorNotFound;
import com.example.vaccineManagement.Exceptions.UserNotFound;

public interface AppointmentService{
   public void bookAppointMent(AppointmentDto appointment)throws UserNotFound, DoctorNotFound;
}
