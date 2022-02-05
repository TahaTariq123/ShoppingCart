package com.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.model.Customer;
@Repository("customerDAO")
public class CustomerDAOImpl extends AbstractDAO<Integer, Customer> implements CustomerDAO{

	@Override
	public Customer findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveCustomer(Customer customer) {
		persist(customer);
	}

	@Override
	public void deleteCustomerByName(String name) {
		Criteria criteria =  createEntityCriteria();
        Customer customer=(Customer)criteria.add(Restrictions.eq("name", name)).uniqueResult();
        delete(customer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAllCustomers() {
		Criteria criteria = createEntityCriteria();
        return (List<Customer>) criteria.list();
	}

	@Override
	public Customer findCustomerByName(String name) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Customer) criteria.uniqueResult();
	}
	
	@Override
	public Customer findCustomerByUsername(String username) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username", username));
        return (Customer) criteria.list();
	}
}
