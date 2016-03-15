package org.jrue.poc;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("1")
			.password("1")
			.roles("ADMIN","USER")
		.and()
			.withUser("2")
			.password("2")
			.roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf()
			.disable()
			.authorizeRequests()
			.antMatchers("/customers")
			.permitAll()
			.antMatchers("/customers/**")
			.access("hasRole('ADMIN')")
		.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/login")
			.failureUrl("/login?error")
			.defaultSuccessUrl("/customers")
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll();
	}
	
}
