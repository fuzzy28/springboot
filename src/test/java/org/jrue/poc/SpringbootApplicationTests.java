package org.jrue.poc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootApplication.class)
@WebAppConfiguration
public class SpringbootApplicationTests {

	@Autowired
	WebApplicationContext webAppContext;
	
	MockMvc mockMvc;
	
	@Before
	public void setUpMockMVC() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(webAppContext)
				.apply(springSecurity())
				.build();
	}
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void unauthenticatedUser() throws Exception {
		 mockMvc
		 .perform(get("/customers"))
		 	.andExpect(status().is3xxRedirection())
		 	.andExpect(redirectedUrl("http://localhost/login"));		 
	}
	
	@Test
	@WithMockUser(username="1",password="1",roles={"ADMIN","USER"})
	public void showCustomersWithAuthenticatedUser() throws Exception {
		 mockMvc
		 .perform(get("/customers"))
		 	.andExpect(status().isOk())
		 .andExpect(view().name("customers"))
		 .andExpect(model().attributeExists("customers"))
		 .andExpect(model().attribute("customers", notNullValue()));
	}
}
