package com.cindysresumeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		List<Appointment> lAppts = resumeManager.findAllAppts();
		for (Appointment a : lAppts) {
			System.out.println("Appointment " + a.getId() + ": " + a);
		}
		return new ModelAndView("appointmentScheduler", "appointments", resumeManager.findAllAppts());
	}

	@RequestMapping(value = "/appointmentConfirmation", method = RequestMethod.POST)
	public ModelAndView sendAppointmentConfirmation(@Validated @ModelAttribute("appointment") Appointment appointment) {
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
