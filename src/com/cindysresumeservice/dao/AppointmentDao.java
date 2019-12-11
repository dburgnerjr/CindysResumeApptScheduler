package com.cindysresumeservice.dao;

import java.util.List;

import com.cindysresumeservice.model.Appointment;
 
public interface AppointmentDao {
    void saveAppointment(Appointment appt);
    
    List<Appointment> findAllAppts();
     
    void deleteApptById(Long id);
     
    Appointment findById(Long id);
     
    void updateAppt(Appointment appt);
}
