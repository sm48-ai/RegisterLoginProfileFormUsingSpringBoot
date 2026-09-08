package com.reg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping("/register")
	public String registerUser(User user) {
	  userService.registerUser(user);
	  return "redirect:/regPage";
	}
}
