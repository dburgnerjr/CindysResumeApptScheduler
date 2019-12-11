package com.cindysresumeservice.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.cindysresumeservice.model.Appointment;

@Repository("appointmentDao")
public class AppointmentDaoImpl implements AppointmentDao {

    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

	public void saveAppointment(Appointment appt) {
		getSession().persist(appt);
	}

	public List<Appointment> findAllAppts() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Appointment> criteria = builder.createQuery(Appointment.class);
		criteria.select(criteria.from(Appointment.class));
		List<Appointment> apptList = getSession().createQuery(criteria).getResultList();
		return apptList;
	}

	public void deleteApptById(Long id) {
		Query<?> query = getSession().createSQLQuery("delete from Appointment where id = :id");
        query.setParameter("id", id).executeUpdate();		
	}

	public Appointment findById(Long id) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Appointment> criteria = builder.createQuery(Appointment.class);
	    criteria.select(criteria.from(Appointment.class)).where(builder.equal(criteria.from(Appointment.class).get("id"), id));
		List<Appointment> apptList = getSession().createQuery(criteria).getResultList();
		return apptList.get(0);
	}

	public void updateAppt(Appointment appt) {
		getSession().update(appt);
	}

}
