package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	User findById(int id);
    
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserByUname(String uname);
 
    List<User> findAllUsers(); 
     
    User findUserByUname(String uname);
 
    boolean isUserUnameUnique(Integer id, String uname);
}
