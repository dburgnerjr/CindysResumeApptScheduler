package com.cindysresumeservice.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cindysresumeservice.model.Appointment;
import com.cindysresumeservice.service.ResumeService;

@Controller
public class IndexController {
	@Autowired
	public ResumeService resumeService;

	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String getIndexPage() {
		return "index";
	}
		
	@RequestMapping(value = "/newAppointment", method = RequestMethod.GET)
	public ModelAndView newAppointment() {
		return new ModelAndView("newAppointment", "appointment", new Appointment());
	}

	@RequestMapping(value = "/appointmentScheduler", method = RequestMethod.GET)
	public ModelAndView getAppointmentScheduler() {
		return new ModelAndView("appointmentScheduler", "appointment", resumeService.findAllAppts());
	}

	@RequestMapping(value = "/appointmentConfirmation", method = RequestMethod.POST)
	public ModelAndView getAppointmentConfirmation(@Validated @ModelAttribute("appointment") Appointment appointment) {
		ModelAndView mavView = new ModelAndView();
		
		String dateAppointment = appointment.getDate();
	
		try {
			Date dtDateOld = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(dateAppointment);
			DateFormat dfDateTgt = new SimpleDateFormat("MM/dd/yyyy h:mm a");
			appointment.setDate(dfDateTgt.format(dtDateOld));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			             
		mavView.addObject("name", appointment.getName());
		mavView.addObject("date", appointment.getDate());
		mavView.addObject("email", appointment.getEmail());
		mavView.addObject("comments", appointment.getComments());
		
        resumeService.saveAppt(appointment);
        mavView.setViewName("appointmentConfirmation");
        
        return mavView;
    }
}
