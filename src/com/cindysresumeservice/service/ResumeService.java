package com.cindysresumeservice.service;

import java.util.List;

import com.cindysresumeservice.model.User;
 
public interface ResumeService {
     
    User findById(long id);
     
    User findByName(String name);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserById(long id);
 
    List<User> findAllUsers(); 
     
    void deleteAllUsers();
     
    public boolean isUserExist(User user);
     
}