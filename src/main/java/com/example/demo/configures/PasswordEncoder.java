package com.example.demo.configures;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {

		BCryptPasswordEncoder  encoder = new BCryptPasswordEncoder();
		String rawpassword="2023";
		String encodedPassword = encoder.encode(rawpassword);
		
		System.out.println(encodedPassword);
		
	}

}
