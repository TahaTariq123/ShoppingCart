package com.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.model.User;

@Repository("userDao")
public class UserDAOImpl extends AbstractDAO<Integer, User> implements UserDAO{

	@Override
	public User findById(int id) {
		return getByKey(id);
	}
	@Override
	public void saveUser(User user) {
		persist(user);
	}
	@Override
	public void deleteUserByUname(String uname) {
		Criteria criteria =  createEntityCriteria();
        User user=(User)criteria.add(Restrictions.eq("uname", uname)).uniqueResult();
        delete(user);
	}
	@Override
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
	}
	@Override
	public User findUserByUname(String uname) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("uname", uname));
        return (User) criteria.uniqueResult();
	}
}
