package com.hospitalmanagement.config;

import java.security.AuthProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.hospitalmanagement.service.customeuserdetailservice;

@Configuration
@EnableWebSecurity
public class Sconfig {
	
	@Bean  
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public Sconfig (customeuserdetailservice userdetailservice) {
		this.userdetailservice = userdetailservice;
	}

	@Autowired
	private customeuserdetailservice userdetailservice;
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authprovider = new DaoAuthenticationProvider();
		authprovider.setUserDetailsService(userdetailservice);
		authprovider.setPasswordEncoder(passwordEncoder());
		return authprovider;
	}
	
	@Bean
	public AuthenticationManager AuthenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception{
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.authenticationProvider(authProvider())
				.build();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeRequests()
		.requestMatchers("/appoinment/**").hasAnyRole("USER","ADMIN")
		.requestMatchers("/doctor/**").hasRole("ADMIN")
		.requestMatchers("/patient/**").hasRole("USER")
		.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
		.requestMatchers("/login", "/register").permitAll()
		.anyRequest().authenticated()
		.and()
		.httpBasic()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.permitAll();
		
		return http.build();
	}
	
}
