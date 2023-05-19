package com.project.cloud.application;


import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.*;
 
@Configuration
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
 
    @Bean
    public DaoAuthenticationProvider authenticationProvider1() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
 
        return authProvider;
    }
 
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider1());
 
        http.authorizeRequests().antMatchers("/").permitAll();
 
        http.antMatcher("/reception/**")
            .authorizeRequests().anyRequest().hasAuthority("RECEPTIONIST")
            .and()
            .formLogin()
                .loginPage("/reception/login")
                    .usernameParameter("email")
                    .loginProcessingUrl("/reception/login")
                    
                    .defaultSuccessUrl("/reception/home")
                    .permitAll()
                    
                .and()
                    .logout()
                        .logoutUrl("/reception/logout")
                        .logoutSuccessUrl("/");
 
    }
}
