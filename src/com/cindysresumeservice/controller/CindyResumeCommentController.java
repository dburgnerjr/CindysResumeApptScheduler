package com.cindysresumeservice.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cindysresumeservice.manager.ResumeManager;
import com.cindysresumeservice.model.Appointment;

@Controller
public class CindyResumeCommentController {

	@Autowired
	private ResumeManager resumeManager; // Service which will do all data retrieval/manipulation work

	// -------------------Retrieve Single
	// Appointment--------------------------------------------------------
	@RequestMapping(value = "/newComment/{id}", method = RequestMethod.GET)
	public ModelAndView getAppointmentById(@PathVariable("id") Long id) {
		Appointment appt = resumeManager.findById(id);

		String strDate = "";
		DateFormat dfDateTgt = new SimpleDateFormat("MM/dd/yyyy h:mm a");
		strDate = dfDateTgt.format(appt.getDate());

		ModelAndView mavView = new ModelAndView();
		mavView.setViewName("newComment");

		mavView.addObject("name", appt.getName());
		mavView.addObject("date", strDate);
		mavView.addObject("email", appt.getEmail());
		mavView.addObject("comments", appt.getComments());

		return mavView;
	}

	@RequestMapping(value = "/commentConfirmation", method = RequestMethod.POST)
	public ModelAndView sendCommentConfirmation(HttpServletRequest req) {
		Appointment appt = new Appointment();
		Date dtDate = null;

		Long lId = Long.valueOf(req.getParameter("id"));
		String strName = req.getParameter("name");
		String strDate = req.getParameter("date");
		String strEmail = req.getParameter("email");
		String strComments = req.getParameter("comments");

		ModelAndView mavView = new ModelAndView();
		mavView.setViewName("commentConfirmation");

		try {
			appt.setId(lId);
			appt.setName(strName);

			dtDate = new SimpleDateFormat("MM/dd/yyyy h:mm a").parse(strDate);
			appt.setDate(dtDate);

			appt.setEmail(strEmail);
			appt.setComments(strComments);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mavView.addObject("name", appt.getName());
		mavView.addObject("date", strDate);
		mavView.addObject("email", appt.getEmail());
		mavView.addObject("comments", appt.getComments());

		resumeManager.updateAppt(appt);
		return mavView;
	}
}
