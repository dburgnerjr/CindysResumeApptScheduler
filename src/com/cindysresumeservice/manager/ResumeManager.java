package com.cindysresumeservice.manager;

import java.util.List;

import com.cindysresumeservice.model.Appointment;

public interface ResumeManager {
	Appointment findById(Long id);

	void saveAppt(Appointment appt);

	void updateAppt(Appointment appt);

	void deleteApptById(Long id);

	List<Appointment> findAllAppts();

	boolean isApptExist(Appointment appt);
}
