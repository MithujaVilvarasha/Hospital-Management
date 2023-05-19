package com.project.cloud.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(2)
public class DoctorSecurityConfig extends WebSecurityConfigurerAdapter {

	 @Override
	    public void configure(HttpSecurity http) throws Exception {
	        
	 
	        
	        
	        http.antMatcher("/doctor/**")
	            .authorizeRequests().anyRequest().hasAuthority("DOCTOR")
	            .and()
	            .formLogin()
	                .loginPage("/doctor/login")
	                    .usernameParameter("email")
	                    .loginProcessingUrl("/doctor/login")
	                    .defaultSuccessUrl("/doctor/home")
	                    .permitAll()
	                .and()
	                    .logout()
	                        .logoutUrl("/doctor/logout")
	                        .logoutSuccessUrl("/");
	 
	    }
}
