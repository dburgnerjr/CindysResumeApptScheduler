package com.cindysresumeservice.controller;

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
	ResumeService resumeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getIndexPage() {
		return new ModelAndView("IndexPage");
	}

	@RequestMapping(value = "/appointment_scheduler", method = RequestMethod.GET)
	public ModelAndView getAppointmentScheduler() {
		return new ModelAndView("appointment_scheduler", "appointment", new Appointment());
	}

	@RequestMapping(value = "/appointment_confirmation", method = RequestMethod.POST)
	public String getAppointmentConfirmation(@Validated @ModelAttribute("appointment") Appointment appointment, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        
        model.addAttribute("name", appointment.getName());
        model.addAttribute("date", appointment.getDate());
        model.addAttribute("time", appointment.getTime());
        model.addAttribute("email", appointment.getEmail());
        model.addAttribute("comments", appointment.getComments());
        
        return "appointment_confirmation";
    }

}
