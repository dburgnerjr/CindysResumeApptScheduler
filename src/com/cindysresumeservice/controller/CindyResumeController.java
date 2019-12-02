package com.cindysresumeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cindysresumeservice.service.ResumeService;
import com.cindysresumeservice.model.Appointment;

/*
 * author: Daniel Burgner
 * 
 */
 
@RestController
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
  
    //-------------------Retrieve Single Appointment--------------------------------------------------------
      
    @RequestMapping(value = "/appointments/appointment/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
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
      
    @RequestMapping(value = "/appointments/appointment", method = RequestMethod.POST)
    public ResponseEntity<Void> createAppointment(@RequestBody Appointment appt, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Appointment " + appt.getName());
  
        if (resumeService.isApptExist(appt)) {
            System.out.println("A Appointment with name " + appt.getName() + " already exists");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        resumeService.saveAppt(appt);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/appointments/appointment/{id}").buildAndExpand(appt.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
    //------------------- Update a Appointment --------------------------------------------------------
      
    @RequestMapping(value = "/appointments/appointment/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") long id, @RequestBody Appointment appt) {
        System.out.println("Updating Appointment " + id);
          
        Appointment currentAppointment = resumeService.findById(id);
          
        if (currentAppointment == null) {
            System.out.println("Appointment with id " + id + " not found");
            return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
        }
  
        currentAppointment.setName(appt.getName());
        currentAppointment.setDate(appt.getDate());
        currentAppointment.setTime(appt.getTime());
        currentAppointment.setEmail(appt.getEmail());
        currentAppointment.setComments(appt.getComments());
         
        resumeService.updateAppt(currentAppointment);
        return new ResponseEntity<Appointment>(currentAppointment, HttpStatus.OK);
    }
     
    //------------------- Delete a Appointment --------------------------------------------------------
      
    @RequestMapping(value = "/appointments/appointment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Appointment with id " + id);
  
        Appointment appt = resumeService.findById(id);
        if (appt == null) {
            System.out.println("Unable to delete. Appointment with id " + id + " not found");
            return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
        }
  
        resumeService.deleteApptById(id);
        return new ResponseEntity<Appointment>(HttpStatus.NO_CONTENT);
    }
  
    //------------------- Delete All Appointments --------------------------------------------------------
      
    @RequestMapping(value = "/appointments/", method = RequestMethod.DELETE)
    public ResponseEntity<Appointment> deleteAllAppointments() {
        System.out.println("Deleting All Appointments");
  
        resumeService.deleteAllAppts();
        return new ResponseEntity<Appointment>(HttpStatus.NO_CONTENT);
    }

}
