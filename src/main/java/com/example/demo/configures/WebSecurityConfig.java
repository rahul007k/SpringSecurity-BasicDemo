package com.example.demo.configures;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource ;
	
	
	@Bean
    public	UserDetailsService userDetailsService() {
	return new CustomUserDetailService();
	 
   }
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder () {
		
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity security) {
	    security.ignoring().antMatchers("/assets/**");
	}
	
	
		
	@Bean
	public DaoAuthenticationProvider  authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider()); 
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
    
		httpSecurity.authorizeRequests().antMatchers("/list_users").authenticated()
		.anyRequest()
		.permitAll()
		.and()
		.formLogin().usernameParameter("email")
		.defaultSuccessUrl("/list_users")
		.permitAll()
		.and()
		.logout().logoutSuccessUrl("/").permitAll()
		;
		httpSecurity.csrf().disable();
	};
	

}


