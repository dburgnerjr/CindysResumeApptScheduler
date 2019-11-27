package com.cindysresumeservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
 
import org.springframework.stereotype.Service;
 
import com.cindysresumeservice.model.Appointment;
 
@Service
public class ResumeServiceImpl implements ResumeService {
     
//    private static final AtomicLong counter = new AtomicLong();
//     
//    private static List<Appointment> appointments;
//    private static List<TestApps> testApps;
//     
//    static {
//        appointments = populateDummyAppointments();
//        testApps = populateDummyAppointments1();
//    }
// 
//    private static List<TestApps> populateDummyAppointments1() {
//    	TestApps test = new TestApps();
//    	test.setName("hi");
//    	if(testApps.size() != 1) {
//    		System.out.println("0");
//    	}
//        testApps.add(test);
//        System.out.println("List size is: " + testApps.size());
//        return testApps;
//    }
//    
//    private static List<Appointment> populateDummyAppointments() {
////        appointments.add(new Appointment(1, "Sam", "11/12/2019", "1:00 PM", "sam@abc.com", ""));
////        appointments.add(new Appointment(2, "Tomy", "11/12/2019", "2:00 PM", "tomy@abc.com", ""));
////        appointments.add(new Appointment(3, "Kelly", "11/12/2019", "3:00 PM", "kelly@abc.com", ""));
////        System.out.println("List size is: " + appointments.size());
//        return appointments;
//    }
//
//    public List<TestApps> findAllAppts() {
//        System.out.println("Counter is: " + counter);
//        return testApps;
//    }
//     
//    public Appointment findById(Long id) {
//        for (Appointment appt : appointments) {
//            if (appt.getId() == id) {
//                return appt;
//            }
//        }
//        return null;
//    }
//     
//    public Appointment findByName(String name) {
//        for(Appointment appt : appointments) {
//            if (appt.getName().equalsIgnoreCase(name)) {
//                return appt;
//            }
//        }
//        return null;
//    }
//     
//    public void saveAppt(Appointment appt) {
//    	appt.setId(counter.incrementAndGet());
//        appointments.add(appt);
//    }
// 
//    public void updateAppt(Appointment appt) {
//        int index = appointments.indexOf(appt);
//        appointments.set(index, appt);
//    }
// 
//    public void deleteApptById(Long id) {
//         
//        for (Iterator<Appointment> iterator = appointments.iterator(); iterator.hasNext();) {
//            Appointment appts = iterator.next();
//            if (appts.getId() == id) {
//                iterator.remove();
//            }
//        }
//    }
// 
//    public boolean isApptExist(Appointment appt) {
//        return findByName(appt.getName()) != null;
//    }
//     
//    public void deleteAllAppts() {
//        appointments.clear();
//    }
  
}