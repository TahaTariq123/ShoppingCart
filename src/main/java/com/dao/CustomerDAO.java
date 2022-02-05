package com.dao;

import java.util.List;

import com.model.Customer;

public interface CustomerDAO {
	Customer findById(int id);
	 
    void saveCustomer(Customer customer);
     
    void deleteCustomerByName(String name);
     
    List<Customer> findAllCustomers();
 
    Customer findCustomerByName(String name);
    
    Customer findCustomerByUsername(String username);
}
