package com.cindysresumeservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "date", nullable = false)
	@JsonFormat(pattern = "MM/dd/yyyy h:mm a")
	private LocalDateTime date;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "comments")
	private String comments;

	public Appointment() {
	}

	public Appointment(Long id, String name, LocalDateTime date, String email, String comments) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.email = email;
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", name=" + name + ", date/time=" + date + ", email=" + email + ", comments="
				+ comments + "]";
	}
}
