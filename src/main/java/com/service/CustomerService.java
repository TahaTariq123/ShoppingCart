package com.service;

import java.util.List;

import com.model.Customer;

public interface CustomerService {
	Customer findById(int id);
    
    void saveCustomer(Customer customer);
     
    void updateCustomer(Customer customer);
     
    void deleteCustomerByName(String name);
 
    List<Customer> findAllCustomers(); 
     
    Customer findCustomerByName(String name);
 
    boolean isCustomerNameUnique(Integer id, String name);
    
    Customer findCustomerByUsername(String username); 
}
