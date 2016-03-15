package org.jrue.poc;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@RequestMapping()
	public String showCustomers(Model model) {		
		model.addAttribute("customers", getCustomerInfo());
		return "customers";
	}
	
	@RequestMapping("/{customerId}")
	public @ResponseBody String showCustomerInfo(@PathVariable String customerId) {		
		return "{name: "  + getCustomerInfo().get(customerId)  + "}";
	}
		
	static Map<String, String> getCustomerInfo() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("0001", "joel ruelos");
		map.put("0002", "paul mendoza");
		return map;
	}	
}