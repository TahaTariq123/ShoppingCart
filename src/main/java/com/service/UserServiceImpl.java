package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.UserDAO;
import com.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserDAO dao;
	
	@Override
	public User findById(int id) {
		return dao.findById(id);
	}
	@Override
	public void saveUser(User user) {
		dao.saveUser(user);
	}
	@Override
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
        	entity.setUpass(user.getUpass());
        }
	}
	@Override
	public void deleteUserByUname(String uname) {
		dao.deleteUserByUname(uname);
	}
	@Override
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}
	@Override
	public User findUserByUname(String uname) {
		return dao.findUserByUname(uname);
	}
	@Override
	public boolean isUserUnameUnique(Integer id, String uname) {
		User user = findUserByUname(uname);
        return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
}
