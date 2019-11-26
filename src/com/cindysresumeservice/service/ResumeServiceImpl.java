package com.cindysresumeservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
 
import org.springframework.stereotype.Service;
 
import com.cindysresumeservice.model.Appointment;
 
@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
     
    private static final AtomicLong counter = new AtomicLong();
     
    private static List<Appointment> appointments;
     
    static {
        appointments = populateDummyAppointments();
    }
 
    private static List<Appointment> populateDummyAppointments() {
        List<Appointment> appts = new ArrayList<Appointment>();
        appts.add(new Appointment(counter.incrementAndGet(), "Sam", "11/12/2019", "1:00 PM", "sam@abc.com", ""));
        appts.add(new Appointment(counter.incrementAndGet(), "Tomy", "11/12/2019", "2:00 PM", "tomy@abc.com", ""));
        appts.add(new Appointment(counter.incrementAndGet(), "Kelly", "11/12/2019", "3:00 PM", "kelly@abc.com", ""));
        System.out.println("List size is: " + appts.size());
        return appts;
    }

    public List<Appointment> findAllAppts() {
        return appointments;
    }
     
    public Appointment findById(Long id) {
        for (Appointment appt : appointments) {
            if (appt.getId() == id) {
                return appt;
            }
        }
        return null;
    }
     
    public Appointment findByName(String name) {
        for(Appointment appt : appointments) {
            if (appt.getName().equalsIgnoreCase(name)) {
                return appt;
            }
        }
        return null;
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
        return findByName(appt.getName()) != null;
    }
     
    public void deleteAllAppts() {
        appointments.clear();
    }
  
}