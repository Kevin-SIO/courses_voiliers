package com.simplon.course_voilier.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.simplon.course_voilier.model.Entreprise;
import com.simplon.course_voilier.service.EntrepriseService;

@Controller
public class EntrepriseController {

	@Autowired
	EntrepriseService es;
	
	@GetMapping("/sponsors")
	public String getSponsor(Model model) {
		
		model.addAttribute("sponsors", es.getAllSponsor());
		return "sponsors";
	}
	
	@GetMapping("/admin/sponsors")
	public String adminSponsor(Model model) {
		ArrayList<String> titres = new ArrayList<>();
		titres.add("Id");
		titres.add("Nom");
		titres.add("Nom du bateau");
		titres.add("lien image");
		
		model.addAttribute("titres", Entreprise.getAttributes());
		model.addAttribute("objets", es.getAllSponsor());
		return "gestion";
	}
}
