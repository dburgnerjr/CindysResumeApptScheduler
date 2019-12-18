package com.cindysresumeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cindysresumeservice.dao.AppointmentDao;
import com.cindysresumeservice.model.Appointment;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {

//	private static final AtomicLong counter = new AtomicLong();
//
//	private static List<Appointment> appointments = new ArrayList<>();
//
//	static {
//		appointments = populateDummyAppointments();
//	}
//
//	private static List<Appointment> populateDummyAppointments() {
//		appointments.add(new Appointment(counter.incrementAndGet(), "Sam", "11/12/2019 1:00 PM", "sam@abc.com",
//				"")); /* new LocalDateTime(2019, 11, 12, 13, 0), */
//		appointments.add(new Appointment(counter.incrementAndGet(), "Tomy", "11/12/2019 2:00 PM",
//				/* new LocalDateTime(2019, 11, 12, 14, 0), */ "tomy@abc.com", ""));
//		appointments.add(new Appointment(counter.incrementAndGet(), "Kelly", "11/12/2019 3:00 PM",
//				/* new LocalDateTime(2019, 11, 12, 15, 0), */ "kelly@abc.com", ""));
//		return appointments;
//	}
//
//	@Override
//	public List<Appointment> findAllAppts() {
//		return appointments;
//	}

	@Autowired
	private AppointmentDao dao;

	@Override
	public List<Appointment> findAllAppts() {
		return dao.findAllAppts();
	}

	@Override
	public Appointment findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public void saveAppt(Appointment appt) {
		dao.saveAppointment(appt);
	}

	@Override
	public void updateAppt(Appointment appt) {
		dao.updateAppt(appt);
	}

	@Override
	public void deleteApptById(Long id) {
		dao.deleteApptById(id);
	}

	public boolean isApptExist(Appointment appt) {
		return findById(appt.getId()) != null;
	}
}
