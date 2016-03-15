package org.jrue.poc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		
		Customer joel = new Customer();
		joel.setCustomerCode("0001");
		joel.setName("Joel");
		joel.setLastName("Ruelos");
		joel.setGender((byte)1);
		joel.setAge(23);
		customers.add(joel);
		Customer pj = new Customer();
		pj.setCustomerCode("0002");
		pj.setName("PJ");
		pj.setLastName("Mendoza");
		pj.setGender((byte)1);
		pj.setAge(25);		
		customers.add(pj);
		return customers;
	}
	
	public Customer getSingleCustomer(String customerCode) {
		for (Customer c : getAllCustomers()) {
			if(customerCode.equals(c.getCustomerCode())) return c;
		}
		return null;
	}
	
}
