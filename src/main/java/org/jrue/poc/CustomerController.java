package org.jrue.poc;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping()
	public String showCustomers(Model model) {		
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}
	
	@RequestMapping("/{customerId}")
	public String showCustomerInfo(Model model,@PathVariable String customerId) {		
		model.addAttribute("customer", customerService.getSingleCustomer(customerId));
		return "customerdetail";
	}

}