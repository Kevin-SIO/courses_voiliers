package com.simplon.course_voilier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.simplon.course_voilier.model.Admin;
import com.simplon.course_voilier.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService as;
	
	@GetMapping("/admin")
	public String connexionAdmin(Model model) {
//		if(message.equals("erreur")) {
//			model.addAttribute("message","Identifiant et/ou mot de passe incorrect");
//		}
//		else if(message.equals("deconnexion")){
//			model.addAttribute("message", "Deconnexion effectué");
//		}
		
		model.addAttribute("admin", new Admin());
//		
		return "connexion";
	}
	
	@PostMapping("/admin")
	public String connexionAdmin(@ModelAttribute Admin admin, Model model) {
		if(as.connexion(admin.getIdentifiant(), admin.getMdp()) == null) {
			model.addAttribute("erreur", "Identifiant et/ou mot de passe incorrect");
			return "connexion";
		}
		else {
			//TODO creation de session
			return "redirect:/admin/index";
		}
	}
	
}
