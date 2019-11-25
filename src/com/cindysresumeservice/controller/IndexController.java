package com.cindysresumeservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndexPage() {
		return "IndexPage";
	}

	@RequestMapping(value = "/appointment_scheduler", method = RequestMethod.GET)
	public String getAppointmentScheduler() {
		return "appointment_scheduler";
	}

}
