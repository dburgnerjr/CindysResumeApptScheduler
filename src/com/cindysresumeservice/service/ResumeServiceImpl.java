package com.cindysresumeservice.service;

import com.cindysresumeservice.model.Appointment;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
   
@Service
public class ResumeServiceImpl implements ResumeService {
     
    private static final AtomicLong counter = new AtomicLong();
     
    private static List<Appointment> appointments = new ArrayList<>();
     
    static {
        appointments = populateDummyAppointments();
    }
     
    private static List<Appointment> populateDummyAppointments() {
		appointments.add(new Appointment(counter.incrementAndGet(), "Sam", new Date("11/12/2019 1:00 PM"), "sam@abc.com", ""));
		appointments.add(new Appointment(counter.incrementAndGet(), "Tomy", new Date("11/12/2019 2:00 PM"), "tomy@abc.com", ""));
		appointments.add(new Appointment(counter.incrementAndGet(), "Kelly", new Date("11/12/2019 3:00 PM"), "kelly@abc.com", ""));
		return appointments;
    }

    public List<Appointment> findAllAppts() {
        return appointments;
    }
     
    public Appointment findById(Long id) {
    	int nLeft = 0;
    	int nRight = appointments.size() - 1;
    	int nMid = (nLeft + nRight) / 2;
    	Appointment appt = appointments.get(nMid);
    	while (!appointments.get(nMid).getId().equals(id)) {
    		if (appointments.get(nMid).getId() < id) {
    			nLeft = nMid;
    		} else if (appointments.get(nMid).getId() > id) {
    			nRight = nMid;
    		} else {
    			appt = appointments.get(nMid);
    		}
    		nMid = (nLeft + nRight) / 2;
    	}
        return appt;
    }
          
    public void saveAppt(Appointment appt) {
    	appt.setId(counter.incrementAndGet());
        appointments.add(appt);
    }
 
    public void updateAppt(Appointment appt) {
        int index = appointments.indexOf(appt);
        appointments.set(index, appt);
    }
 
    public void deleteApptById(Long id) {        
        for (Iterator<Appointment> iterator = appointments.iterator(); iterator.hasNext();) {
            Appointment appts = iterator.next();
            if (appts.getId() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean isApptExist(Appointment appt) {
        return findById(appt.getId()) != null;
    }     
}
