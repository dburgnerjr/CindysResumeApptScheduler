package com.cindysresumeservice.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cindysresumeservice.model.Appointment;
import com.cindysresumeservice.service.ResumeService;

@Service
public class ResumeManagerImpl implements ResumeManager {
	@Autowired
	private ResumeService resumeService;

	@Override
	public Appointment findById(Long id) {
		return resumeService.findById(id);
	}

	@Override
	public void saveAppt(Appointment appt) {
		resumeService.saveAppt(appt);
	}

	@Override
	public void updateAppt(Appointment appt) {
		resumeService.updateAppt(appt);
	}

	@Override
	public void deleteApptById(Long id) {
		resumeService.deleteApptById(id);
	}

	@Override
	public boolean isApptExist(Appointment appt) {
		return findById(appt.getId()) != null;
	}

	@Override
	public List<Appointment> findAllAppts() {
		return resumeService.findAllAppts();
	}
}
