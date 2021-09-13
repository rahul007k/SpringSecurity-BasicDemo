package com.example.demo.controller;


import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Repo.UserRepository;
import com.example.demo.entity.User;

@Controller
public class AppController {
	
	@Autowired
	private UserRepository repository ;
	
	
	private static final Logger logger = Logger.getLogger(AppController.class);  

	@GetMapping("")
	public String ViewHomePage() {
		return "index";
	}
	
	@GetMapping(value="/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		logger.info("signupdone");
		return "signup_form";
		
	}
	
	
	
	
	
	@PostMapping("/process_register")
		public String processRegistrationForm(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedpassword= encoder.encode(user.getPassword()); 
		user.setPassword(encodedpassword);
		repository.save(user);
		
		logger.info(user);
		return "register_success";
		
	}
	
	@GetMapping("/list_users")
	public String viewAllListUsers(Model model) {
		List<User> listusers=repository.findAll();
		model.addAttribute("listusers", listusers);
		return "users";
		
	}
}
