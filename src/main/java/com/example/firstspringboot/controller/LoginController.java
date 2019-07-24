package com.example.firstspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.firstspringboot.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String login( ModelMap map , @RequestParam String username , @RequestParam String password ) {
		boolean valid = loginService.validateLogin(username, password);
		if(valid) {
			map.put("username",username);
			return "welcome";
		}
		map.put("message","Invalid username or password");
		return "login";
	}
	
}
