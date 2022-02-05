package com.dao;

import java.util.List;

import com.model.User;

public interface UserDAO {

	User findById(int id);
	 
    void saveUser(User user);
     
    void deleteUserByUname(String uname);
     
    List<User> findAllUsers();
 
    User findUserByUname(String uname);
}