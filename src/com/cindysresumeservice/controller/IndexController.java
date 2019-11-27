package com.cindysresumeservice.controller;

import java.util.List;

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
//	@Autowired
//	ResumeService resumeService;
//
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndexPage() {
		return "index";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getHomePage() {
		return "index";
	}
	
	@RequestMapping(value = "/newAppointment", method = RequestMethod.GET)
	public ModelAndView newAppointment() {
		return new ModelAndView("newAppointment", "appointment", new Appointment());
	}

	@RequestMapping(value = "/appointmentScheduler", method = RequestMethod.GET)
	public ModelAndView getAppointmentScheduler() {

		return new ModelAndView("appointmentScheduler");
		// says SEVERE: Invalid property 'name' of bean class [java.util.ArrayList]: Bean property 'name' 
		// is not readable or has an invalid getter method: Does the return type of the getter match the parameter type of the setter?
		// but when the section to add the synchronous submission in appointment_scheduler gets commented out, I see the list 
		// of appointments with no records displayed
	}

	@RequestMapping(value = "/appointmentConfirmation", method = RequestMethod.POST)
	public String getAppointmentConfirmation(@Validated @ModelAttribute("appointment") Appointment appointment, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        
        model.addAttribute("name", appointment.getName());
        model.addAttribute("date", appointment.getDate());
        model.addAttribute("time", appointment.getTime());
        model.addAttribute("email", appointment.getEmail());
        model.addAttribute("comments", appointment.getComments());
        
        return "appointmentConfirmation";
    }
}
