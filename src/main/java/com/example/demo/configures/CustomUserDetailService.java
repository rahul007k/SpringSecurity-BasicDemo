package com.example.demo.configures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Repo.UserRepository;
import com.example.demo.entity.User;

public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;
	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = repo.findByEmail(email);
		if (user==null) {
			throw new UsernameNotFoundException("Please Enter the Correct Email ID / Incorrect UserName");
		}
		return new CustomUserDetails(user);
	}

}
