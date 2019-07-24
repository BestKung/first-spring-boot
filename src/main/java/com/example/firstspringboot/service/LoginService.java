package com.example.firstspringboot.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateLogin(String username , String password) {
		return "admin".equals(username) && "computer".equals(password);
	}
	
	
}
