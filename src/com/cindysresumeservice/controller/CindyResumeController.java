package com.cindysresumeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cindysresumeservice.service.ResumeService;
import com.cindysresumeservice.model.Appointment;

/*
 * author: Daniel Burgner
 * 
 */
 
@Controller
public class CindyResumeController {
	 
    @Autowired
    ResumeService resumeService;  //Service which will do all data retrieval/manipulation work
 
    //-------------------Retrieve All Appointments--------------------------------------------------------
    @RequestMapping(value = "/appointments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Appointment>> listAllAppointments() {
        List<Appointment> appts = resumeService.findAllAppts();
        if (appts.isEmpty()) {
            return new ResponseEntity<List<Appointment>>(HttpStatus.NO_CONTENT);	//You many decide to return HttpStatus.NOT_FOUND
        }
        System.out.println("Appointment size is: " + appts.size());
        return new ResponseEntity<List<Appointment>>(appts, HttpStatus.OK);
    }
  
/*    
  
    //-------------------Retrieve Single Appointment--------------------------------------------------------
      
    @RequestMapping(value = "/appointment_scheduler/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Appointment> getAppointment(@PathVariable("id") long id) {
        System.out.println("Fetching Appointment with id " + id);
        Appointment Appointment = resumeService.findById(id);
        if (Appointment == null) {
            System.out.println("Appointment with id " + id + " not found");
            return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Appointment>(Appointment, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a Appointment--------------------------------------------------------
      
    @RequestMapping(value = "/appointment_scheduler/", method = RequestMethod.POST)
    public ResponseEntity<Void> createAppointment(@RequestBody Appointment Appointment,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Appointment " + Appointment.getName());
  
        if (resumeService.isAppointmentExist(Appointment)) {
            System.out.println("A Appointment with name " + Appointment.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        resumeService.saveAppointment(Appointment);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/appointment_scheduler/{id}").buildAndExpand(Appointment.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a Appointment --------------------------------------------------------
      
    @RequestMapping(value = "/appointment_scheduler/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") long id, @RequestBody Appointment Appointment) {
        System.out.println("Updating Appointment " + id);
          
        Appointment currentAppointment = resumeService.findById(id);
          
        if (currentAppointment == null) {
            System.out.println("Appointment with id " + id + " not found");
            return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
        }
  
        currentAppointment.setName(Appointment.getName());
        currentAppointment.setDate(Appointment.getDate());
        currentAppointment.setTime(Appointment.getTime());
        currentAppointment.setEmail(Appointment.getEmail());
        currentAppointment.setComments(Appointment.getComments());
         
        resumeService.updateAppointment(currentAppointment);
        return new ResponseEntity<Appointment>(currentAppointment, HttpStatus.OK);
    }
  
     
     
    //------------------- Delete a Appointment --------------------------------------------------------
      
    @RequestMapping(value = "/appointment_scheduler/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Appointment with id " + id);
  
        Appointment Appointment = resumeService.findById(id);
        if (Appointment == null) {
            System.out.println("Unable to delete. Appointment with id " + id + " not found");
            return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
        }
  
        resumeService.deleteAppointmentById(id);
        return new ResponseEntity<Appointment>(HttpStatus.NO_CONTENT);
    }
  
      
     
    //------------------- Delete All Appointments --------------------------------------------------------
      
    @RequestMapping(value = "/appointment_scheduler/", method = RequestMethod.DELETE)
    public ResponseEntity<Appointment> deleteAllAppointments() {
        System.out.println("Deleting All Appointments");
  
        resumeService.deleteAllAppointments();
        return new ResponseEntity<Appointment>(HttpStatus.NO_CONTENT);
    }
*/
}
