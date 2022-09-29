package com.simplon.course_voilier.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import com.simplon.course_voilier.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService as;
	
	
	
	@GetMapping("/admin/index")
	public String accueilAdmin() {
			return "accueil_admin";
	}
	

	
	
	
}
