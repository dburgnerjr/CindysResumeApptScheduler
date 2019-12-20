package com.cindysresumeservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cindysresumeservice.manager.ResumeManager;
import com.cindysresumeservice.model.Appointment;

@Controller
public class AppointmentController {

	@Autowired
	private ResumeManager resumeManager;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String getIndexPage() {
		return "index";
	}

	@RequestMapping(value = "/newAppointment", method = RequestMethod.GET)
	public ModelAndView newAppointment() {
		return new ModelAndView("newAppointment", "appointment", new Appointment());
	}

	@RequestMapping(value = "/appointmentScheduler", method = RequestMethod.GET)
	public ModelAndView getAppointmentScheduler() {
		return new ModelAndView("appointmentScheduler", "appointments", resumeManager.findAllAppts());
	}

	@RequestMapping(value = "/buildAppointment", method = RequestMethod.POST)
	public @ResponseBody Appointment buildAppointment(@RequestBody Appointment appt) throws ParseException, IOException {
		try {
			System.out.println("appt:  " + appt);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return appt;
	}

	@RequestMapping(value = "/appointmentConfirmation", method = RequestMethod.POST, produces = "application/json")
	public ModelAndView sendAppointmentConfirmation(@Validated @ModelAttribute("appointment") Appointment appointment) {
		System.out.println("sendAppointmentConfirmation");
		ModelAndView mavView = new ModelAndView();

		mavView.addObject("name", appointment.getName());
		mavView.addObject("date", appointment.getDate());
		mavView.addObject("email", appointment.getEmail());
		mavView.addObject("comments", appointment.getComments());

		resumeManager.saveAppt(appointment);
		mavView.setViewName("appointmentConfirmation");

		return mavView;
	}
}
