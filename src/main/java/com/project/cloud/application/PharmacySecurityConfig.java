package com.project.cloud.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(3)
public class PharmacySecurityConfig extends WebSecurityConfigurerAdapter {

	 @Override
	    public void configure(HttpSecurity http) throws Exception {
	        
	 
	        
	 
	        http.antMatcher("/pharmacy/**")
	            .authorizeRequests().anyRequest().hasAuthority("PHARMACIST")
	            .and()
	            .formLogin()
	                .loginPage("/pharmacy/login")
	                    .usernameParameter("email")
	                    .loginProcessingUrl("/pharmacy/login")
	                    .defaultSuccessUrl("/pharmacy/home")
	                    .permitAll()
	                .and()
	                    .logout()
	                        .logoutUrl("/pharmacy/logout")
	                        .logoutSuccessUrl("/");
	 
	    }
}
