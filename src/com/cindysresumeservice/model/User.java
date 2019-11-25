package com.cindysresumeservice.model;


public class User {
	 
    private long id;
     
    private String username;
     
    private String date;

    private String time;
     
    private String email;

    private String comments;
     
    public User(){
        id=0;
        comments = "";
    }
     
    public User(long id, String username, String date, String time, String email, String comments) {
        this.id = id;
        this.username = username;
        this.date = date;
        this.time = time;
        this.email = email;
        this.comments = comments;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
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
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", date=" + date
                + ", time=" + time + ", email=" + email + ", comments=" + comments + "]";
    }
     
 
     
}
