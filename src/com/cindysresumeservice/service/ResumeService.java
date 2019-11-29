package com.cindysresumeservice.service;

import java.util.List;

import com.cindysresumeservice.model.Appointment;
 
public interface ResumeService {
     
    Appointment findById(Long id);
     
    Appointment findByName(String name);
     
    void saveAppt(Appointment appt);
     
    void updateAppt(Appointment appt);
     
    void deleteApptById(Long id);
 
    List<Appointment> findAllAppts(); 
     
    void deleteAllAppts();
     
    public boolean isApptExist(Appointment appt);
     
}
