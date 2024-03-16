package com.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springdemo.entity.User;
import com.springdemo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public String addUser(User us) {
		us.setPassword(passwordEncoder.encode(us.getPassword()));
		repo.save(us);
		return "user added successfully";
	}
	

}
