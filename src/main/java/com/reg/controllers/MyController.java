package com.reg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reg.entities.User;
import com.reg.repository.UserRepository;
import com.reg.service.UserService;

@Controller
public class MyController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/regPage")
	public String openRegistrationPage(Model model) {
		model.addAttribute("user1", new User());
		return "register";		
	}
	
	@PostMapping("/regForm")
	public String submitRegisterForm(@ModelAttribute("user1") User user,Model model) {
	  boolean status=userService.registerUser(user);
	  if (status) {
		model.addAttribute("successMsg", "User Registered Successfully");
	} else {
		model.addAttribute("errMsg", "User Registration Failed");
	}
	  return "register";
	}
	
	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {
		model.addAttribute("user", new User());
		
		return "login";
	}
	
	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("user") User user,Model model) {
		User validUser=userService.loginUser(user.getEmail(), user.getPassword());
		if(validUser!=null) {
			model.addAttribute("modelUser", validUser);
			return "profile";
		}else {
			model.addAttribute("errMsg", "Email id And Password Didnt Match");
			return "login";
		}
		
	}
}
