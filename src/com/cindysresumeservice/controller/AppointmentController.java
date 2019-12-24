package com.cindysresumeservice.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
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
		String strJSONArray = "";
		StringBuilder sbBuild = new StringBuilder();
		String strLine;
		Appointment appt = new Appointment();
		try {
			BufferedReader brRead = req.getReader();
			while ((strLine = brRead.readLine()) != null) {
				sbBuild.append(strLine);
			}

			strJSONArray = sbBuild.toString();
			JSONObject jsonObject = new JSONObject(strJSONArray);

			appt.setName(jsonObject.getString("name"));
			String strDate = jsonObject.getString("date");

			Date dtDateOld = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(strDate);
			DateFormat dfDateTgt = new SimpleDateFormat("MM/dd/yyyy h:mm a");
			String strDateNew = dfDateTgt.format(dtDateOld);
			Date dtDateNew = new SimpleDateFormat("MM/dd/yyyy h:mm a").parse(strDateNew);
			appt.setDate(dtDateNew);

			appt.setEmail(jsonObject.getString("email"));
			appt.setComments(jsonObject.getString("comments"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView mavView = new ModelAndView();
		System.out.println("appt:  " + appt);

		mavView.addObject("name", appt.getName());
		mavView.addObject("date", appt.getDate());
		mavView.addObject("email", appt.getEmail());
		mavView.addObject("comments", appt.getComments());

		resumeManager.saveAppt(appt);
		mavView.setViewName("appointmentConfirmation");

		return mavView;
	}
}
