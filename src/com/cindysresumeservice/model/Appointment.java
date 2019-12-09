package com.cindysresumeservice.model;

public class Appointment {
	 
    private Long id;
     
    private String name;
     
    private String date;

    private String email;

    private String comments;
     
    public Appointment() {
    }
    
    public Appointment(Long id, String name, String date, String email, String comments) {
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
 
    public String getDate() {
        return date;
    }
 
    public void setDate(String date) {
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
        return "Appointment [id=" + id + ", name=" + name + ", date/time=" + date
                + ", email=" + email + ", comments=" + comments + "]";
    }
}
