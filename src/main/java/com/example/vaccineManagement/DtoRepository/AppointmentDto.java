package com.example.vaccineManagement.DtoRepository;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class AppointmentDto {
    private int docId;
    private int userId;
    private Date date;
    private LocalTime time;
}
