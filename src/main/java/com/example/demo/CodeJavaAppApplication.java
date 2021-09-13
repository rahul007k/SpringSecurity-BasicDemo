package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.example.demo.controller","com.example.demo.configures","com.example.demo.entity","com.example.demo.Repo"})
public class CodeJavaAppApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CodeJavaAppApplication.class, args);
	}

}
