package com.project.cloud.application;

import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByEmail(String email);
}
