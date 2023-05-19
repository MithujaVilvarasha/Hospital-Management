package com.project.cloud.application;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {

	private UserRepository repo;
    
    public DatabaseLoader(UserRepository repo) {
        this.repo = repo;
    }
 
    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            User user1 = new User("doctor@gmail.com", "david123", Role.DOCTOR);
            User user2 = new User("reception@yahoo.com", "john2020", Role.RECEPTIONIST);
            User user3 = new User("pharmacy@gmail.com", "nam2022", Role.PHARMACIST);
            
             
            repo.saveAll(List.of(user1, user2, user3));
             
            System.out.println("Database initialized");
        };
    }
}
