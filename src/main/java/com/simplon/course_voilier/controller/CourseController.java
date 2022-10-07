package com.simplon.course_voilier.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.simplon.course_voilier.model.Course;
import com.simplon.course_voilier.model.Epreuve;
import com.simplon.course_voilier.model.Inscription;
import com.simplon.course_voilier.model.Resultat;
import com.simplon.course_voilier.model.key.InscriptionKey;
import com.simplon.course_voilier.service.CourseService;
import com.simplon.course_voilier.service.EpreuveService;
import com.simplon.course_voilier.service.InscriptionService;
import com.simplon.course_voilier.service.ResultatService;
import com.simplon.course_voilier.service.VoilierService;

@Controller
public class CourseController {

	@Autowired
	CourseService cs;
	@Autowired
	InscriptionService is;
	@Autowired
	EpreuveService es;
	@Autowired
	ResultatService rs;
	@Autowired
	VoilierService vs;
	
	@GetMapping("/admin/courses")
	public String getCourses(Model model) {
		model.addAttribute("type", "courses");
		model.addAttribute("titres", Course.getAttributes());
		model.addAttribute("objets", cs.getAllCourse());
		model.addAttribute("attributs", Course.getAttributesType());
		model.addAttribute("newObject", new Course());
		return "gestion";
	}
	
	@PostMapping("/admin/courses/ajout")
	public String addCourse(@ModelAttribute Course course) {
		cs.addCourse(course);
		
		return "redirect:/admin/courses/" + course.getId();
	}
	
	@GetMapping("/admin/courses/{id}")
	public String updateCourses(@PathVariable int id,Model model) {
		return "update_course";
	}
	
	@GetMapping("/admin/courses/{id}/inscriptions")
	public String inscriptionbyCourse(@PathVariable int id, Model model) {

		ArrayList<String> titres = Inscription.getAttributes();
		titres.remove(2);
		
		ArrayList<String> attributs = Inscription.getAttributesType();
		attributs.remove(2);
		
		model.addAttribute("action", "/admin/courses/"+id+"/inscriptions/ajout");
		model.addAttribute("titres", titres);
		model.addAttribute("objets", is.getInscription(id));
		model.addAttribute("attributs", attributs);
		model.addAttribute("newObject", new InscriptionKey());
		
		return "gestion";
	}
	
	@PostMapping("/admin/courses/{id}/inscriptions/ajout")
	public String addInscription(@PathVariable int id, @ModelAttribute InscriptionKey ik, Model model) {
		
		Inscription inscription = new Inscription();
		
		ik.setCourse(id);
		
		inscription.setId(ik);
		inscription.setDesistement(false);
		
		for(Epreuve epreuve : es.getEpreuve(id)) {
			rs.addResultat(new Resultat(epreuve,vs.getVoilier(id).get()));
		}
		
		is.addInscription(inscription);
		
		return "redirect:/admin/courses/"+id+"/inscriptions";
	}
	
	@GetMapping("/admin/courses/{id}/epreuves")
	public String epreuvebyCourse(@PathVariable int id, Model model) {
		
		ArrayList<String> titres = Epreuve.getAttributes();
		
		ArrayList<String> attributs = Epreuve.getAttributesType();
		
		model.addAttribute("action", "/admin/courses/"+id+"/epreuves/ajout");
		model.addAttribute("titres", titres);
		model.addAttribute("objets", es.getEpreuve(id));
		model.addAttribute("attributs", attributs);
		model.addAttribute("newObject", new Epreuve());
		
		return "gestion";
	}
	
	@PostMapping("/admin/courses/{id}/epreuves/ajout")
	public String addEpreuve(@PathVariable int id, @ModelAttribute Epreuve epreuve, Model model) {
		epreuve.setCourse(cs.getCourse(id).get());
		es.addEpreuve(epreuve);
		
		return "redirect:admin/course/" + id + "/epreuves";
	}
	
	
	@GetMapping("/admin/epreuves/{id}")
	public String  updateEpreuve(@PathVariable int id, Model model) {
		
		model.addAttribute("action", "/admin/epreuves/"+id+"/update");
		model.addAttribute("titres", Epreuve.getAttributes());
		model.addAttribute("attributs", Epreuve.getAttributesType());
		model.addAttribute("objet", es.getEpreuveById(id));
		model.addAttribute("idEpreuve", id);
				
		model.addAttribute("resultats", rs.getResultat(id));
		
		return "update_epreuve";
	}
	
	@PostMapping("/admin/resultat/update")
	public String updateResultat(HttpServletRequest request) {
		
		rs.updateResultat(request.getParameter("temps"), Integer.valueOf(request.getParameter("voilier")), Integer.valueOf(request.getParameter("id")));
		return "redirect:/admin/epreuves/" + request.getParameter("id");
	}
	

}
