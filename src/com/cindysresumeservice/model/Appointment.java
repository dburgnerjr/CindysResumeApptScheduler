package com.cindysresumeservice.model;


public class Appointment {
	 
    private Long id;
     
    private String name;
     
    private String date;

    private String time;
     
    private String email;

    private String comments;
     
    public Appointment() {
        id = (long) 0;
        comments = "";
    }
     
    public Appointment(Long id, String name, String date, String time, String email, String comments) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
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

    public String getTime() {
        return time;
    }
 
    public void setTime(String time) {
        this.time = time;
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Appointment))
            return false;
        Appointment other = (Appointment) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Appointment [id=" + id + ", name=" + name + ", date=" + date
                + ", time=" + time + ", email=" + email + ", comments=" + comments + "]";
    }
     
 
     
}
