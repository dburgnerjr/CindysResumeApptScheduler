package com.cindysresumeservice.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cindysresumeservice.dao.AppointmentDao;
import com.cindysresumeservice.model.Appointment;

public class ResumeManagerImpl {
	@Autowired
    private AppointmentDao dao;
          
    public List<Appointment> findAllAppts() {
        return dao.findAllAppts();
    }
     
    public Appointment findById(Long id) {
    	return dao.findById(id);
    }
          
    public void saveAppt(Appointment appt) {
    	dao.saveAppointment(appt);
    }
 
    public void updateAppt(Appointment appt) {
    	dao.updateAppt(appt);
    }
 
    public void deleteApptById(Long id) {
    	dao.deleteApptById(id);
    } 
}
