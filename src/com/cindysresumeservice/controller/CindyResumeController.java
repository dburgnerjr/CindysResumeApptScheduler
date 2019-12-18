package com.cindysresumeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cindysresumeservice.manager.ResumeManager;
import com.cindysresumeservice.model.Appointment;

/*
 * author: Daniel Burgner
 * 
 */

@RestController
public class CindyResumeController {

	@Autowired
	private ResumeManager resumeManager; // Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All
	// Appointments--------------------------------------------------------
	@RequestMapping(value = "/appointments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Appointment>> listAllAppointments() {
		List<Appointment> appts = resumeManager.findAllAppts();
		if (appts.isEmpty()) {
			// You many decide to return HttpStatus.NOT_FOUND
			return new ResponseEntity<List<Appointment>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Appointment>>(appts, HttpStatus.OK);
		}
	}

	// -------------------Retrieve Single
	// Appointment--------------------------------------------------------

	@RequestMapping(value = "/appointment/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Appointment> getAppointment(@PathVariable("id") Long id) {
		Appointment appt = resumeManager.findById(id);
		if (null == appt) {
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Appointment>(appt, HttpStatus.OK);
		}
	}

	// -------------------Create a
	// Appointment--------------------------------------------------------

	@RequestMapping(value = "/appointments/appointment", method = RequestMethod.POST)
	public ResponseEntity<Void> createAppointment(@RequestBody Appointment appt) {
		if (resumeManager.isApptExist(appt)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			resumeManager.saveAppt(appt);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}

	// ------------------- Update a Appointment
	// --------------------------------------------------------

	@RequestMapping(value = "/appointment/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") Long id, @RequestBody Appointment appt) {
		Appointment currentAppointment = resumeManager.findById(id);

		if (currentAppointment == null) {
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		} else {
			currentAppointment.setName(appt.getName());
			currentAppointment.setDate(appt.getDate());
			currentAppointment.setEmail(appt.getEmail());
			currentAppointment.setComments(appt.getComments());

			resumeManager.updateAppt(currentAppointment);
			return new ResponseEntity<Appointment>(currentAppointment, HttpStatus.OK);
		}
	}

	// ------------------- Delete a Appointment
	// --------------------------------------------------------

	@RequestMapping(value = "/appointment/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Appointment> deleteAppointment(@PathVariable("id") Long id) {
		Appointment appt = resumeManager.findById(id);
		if (appt == null) {
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		} else {
			resumeManager.deleteApptById(id);
			return new ResponseEntity<Appointment>(HttpStatus.OK);
		}
	}
}
