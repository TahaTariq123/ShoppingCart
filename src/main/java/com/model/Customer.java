package com.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Digits;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="customer_dto")
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customer_no;
 
    @Size(min=3, max=50)
    private String customer_name;
    
    @NotEmpty
    private String username;
    @NotEmpty
    @Size(min=6)
    private String password;
    @NotNull
    @Size(min = 10, max=12)
    private String mobile;
    private String email;
    @NotEmpty
    private String customer_address;
    @NotEmpty
    private String customer_city;
    @OneToMany(mappedBy = "cust", fetch = FetchType.LAZY)
	private Set<Invoice> invoices;
	
    
    public int getCustomer_no() {
		return customer_no;
	}

	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public String getCustomer_city() {
		return customer_city;
	}

	public void setCustomer_city(String customer_city) {
		this.customer_city = customer_city;
	}
	
	public Set<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + customer_no;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Customer))
            return false;
        Customer other = (Customer) obj;
        if (customer_no != other.customer_no)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

	@Override
	public String toString() {
		return "Customer [customer_no=" + customer_no + ", customer_name=" + customer_name + ", username=" + username
				+ ", password=" + password + ", mobile=" + mobile + ", email=" + email + ", customer_address="
				+ customer_address + ", customer_city=" + customer_city + "]";
	}
 
    

}


