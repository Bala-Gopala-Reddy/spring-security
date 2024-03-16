package com.springdemo.config;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springdemo.repository.UserRepository;
import com.springdemo.entity.*;
public class UserInfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// TODO Auto-generated method stub
	    Optional<User> user=repo.findByUserName(username);
		return user.map(UserInfoUserDetails::new)
			.orElseThrow(() ->new UsernameNotFoundException("user not found"+username));
		
	}

}
