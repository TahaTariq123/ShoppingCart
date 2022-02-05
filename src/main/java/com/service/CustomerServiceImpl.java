package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.CustomerDAO;
import com.model.Customer;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
    private CustomerDAO dao;
	
	@Override
	public Customer findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveCustomer(Customer customer) {
		dao.saveCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		Customer entity = dao.findById(customer.getCustomer_no());
		if(entity!=null){
        	entity.setCustomer_name(customer.getCustomer_name());
        	entity.setUsername(customer.getUsername());
        	entity.setPassword(customer.getPassword());
        	entity.setMobile(customer.getMobile());
        	entity.setEmail(customer.getEmail());
        	entity.setCustomer_address(customer.getCustomer_address());
        	entity.setCustomer_city(customer.getCustomer_city());
        	entity.setInvoices(customer.getInvoices());
        }
	}

	@Override
	public void deleteCustomerByName(String name) {
		dao.deleteCustomerByName(name);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return dao.findAllCustomers();
	}

	@Override
	public Customer findCustomerByName(String name) {
		return dao.findCustomerByName(name);
	}

	@Override
	public boolean isCustomerNameUnique(Integer id, String name) {
		Customer customer = findCustomerByName(name);
		return ( customer == null || ((id != null) && (customer.getCustomer_no() == id))); 
	}
	
	@Override
	public Customer findCustomerByUsername(String username) {
		return dao.findCustomerByUsername(username);
	}
}
