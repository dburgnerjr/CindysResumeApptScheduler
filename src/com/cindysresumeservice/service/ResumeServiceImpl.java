package com.cindysresumeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cindysresumeservice.dao.AppointmentDao;
import com.cindysresumeservice.model.Appointment;

@Service
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
//		int nLeft = 0;
//		int nRight = appointments.size() - 1;
//		int nMid = (nLeft + nRight) / 2;
//		Appointment appt = appointments.get(nMid);
//		while (!appointments.get(nMid).getId().equals(id)) {
//			if (appointments.get(nMid).getId() < id) {
//				nLeft = nMid;
//			} else if (appointments.get(nMid).getId() > id) {
//				nRight = nMid;
//			} else {
//				appt = appointments.get(nMid);
//			}
//			nMid = (nLeft + nRight) / 2;
//		}
		return null;
	}

	@Override
	public void saveAppt(Appointment appt) {
//		appt.setId(counter.incrementAndGet());
//		appointments.add(appt);
	}

	@Override
	public void updateAppt(Appointment appt) {
//		int index = appointments.indexOf(appt);
//		appointments.set(index, appt);
	}

	@Override
	public void deleteApptById(Long id) {
//		for (Iterator<Appointment> iterator = appointments.iterator(); iterator.hasNext();) {
//			Appointment appts = iterator.next();
//			if (appts.getId() == id) {
//				iterator.remove();
//			}
//		}
	}

	@Override
	public boolean isApptExist(Appointment appt) {
		return findById(appt.getId()) != null;
	}
}
