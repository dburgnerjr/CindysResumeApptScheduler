package com.cindysresumeservice.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		return new ModelAndView("appointmentScheduler", "appointments", resumeManager.findAllAppts());
	}

	@RequestMapping(value = "/appointmentConfirmation", method = RequestMethod.POST)
	public ModelAndView sendAppointmentConfirmation(HttpServletRequest req) {
		System.out.println("sendAppointmentConfirmation");
		Appointment appt = new Appointment();
		Date dtDateOld = null;
		String strDateNew = "";

		String strName = req.getParameter("name");
		String strDate = req.getParameter("date");
		String strEmail = req.getParameter("email");
		String strComments = req.getParameter("comments");

		ModelAndView mavView = new ModelAndView();
		mavView.setViewName("appointmentConfirmation");

		try {
			appt.setName(strName);

			dtDateOld = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(strDate);
			DateFormat dfDateTgt = new SimpleDateFormat("MM/dd/yyyy h:mm a");
			strDateNew = dfDateTgt.format(dtDateOld);
			Date dtDateNew = new SimpleDateFormat("MM/dd/yyyy h:mm a").parse(strDateNew);
			appt.setDate(dtDateNew);

			appt.setEmail(strEmail);
			appt.setComments(strComments);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mavView.addObject("name", appt.getName());
		mavView.addObject("date", strDateNew);
		mavView.addObject("email", appt.getEmail());
		mavView.addObject("comments", appt.getComments());

		resumeManager.saveAppt(appt);
		return mavView;
	}
}
