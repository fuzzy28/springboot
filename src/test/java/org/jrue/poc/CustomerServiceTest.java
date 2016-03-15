package org.jrue.poc;

import static org.junit.Assert.*;

import org.jrue.poc.domain.Customer;
import org.jrue.poc.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= {SpringbootApplication.class})
public class CustomerServiceTest {

	@Autowired
	CustomerService service;
	
	@Test
	public void getAllCustomers() {
		assertEquals(service.getAllCustomers().size(), 2);
	}
	
	@Test
	public void getSingleCustomers() {
		Customer customer = service.getSingleCustomer("0001");
		assertEquals(customer.getName(), "Joel");
		assertEquals(customer.getLastName(), "Ruelos");
	}
	
}
