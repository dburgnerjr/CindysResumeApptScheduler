package com.cindysresumeservice.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cindysresumeservice.model.Appointment;

@Repository("appointmentDao")
@Transactional
public class AppointmentDaoImpl implements AppointmentDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveAppointment(Appointment appt) {
		getSession().persist(appt);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Appointment> findAllAppts() {
		Criteria criteria = getSession().createCriteria(Appointment.class);
		return criteria.list();
	}

	@Override
	public void deleteApptById(Long id) {
		Query query = getSession().createSQLQuery("delete from Appointment where id = :id");
		query.setParameter("id", id).executeUpdate();
	}

	@Override
	public Appointment findById(Long id) {
		Criteria criteria = getSession().createCriteria(Appointment.class);
		criteria.add(Restrictions.eq("id", id));
		return (Appointment) criteria.uniqueResult();
	}

	@Override
	public void updateAppt(Appointment appt) {
		getSession().update(appt);
	}

}
