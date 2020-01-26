package com.vlad.thymeleaf.thymeleaf333.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String showHomePage() {
		
		return "redirect:/api/students";
	}

}
