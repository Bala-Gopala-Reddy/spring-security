package com.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entity.User;
import com.springdemo.service.UserService;

@RestController
@RequestMapping("/home")
public class UserController {
	@Autowired
	private UserService service;
	@GetMapping("/normal")
	@PreAuthorize("hasAythoriy('User')")
	public ResponseEntity<String> normalUser() {
		return ResponseEntity.ok("hi i am normal developer");
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<String> adminUser() {
		return ResponseEntity.ok("hi i am admin developer");
		
	}
	@GetMapping("/hello")
	public String hello() {
		return "hello Security";
	}
	
	@PostMapping("/new")
	public String addNewUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	

}
