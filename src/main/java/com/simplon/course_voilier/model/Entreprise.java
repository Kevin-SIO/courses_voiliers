package com.simplon.course_voilier.model;

import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "entreprise")
public class Entreprise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_entreprise")
	private int id;
	
	@Column(name = "nom_entreprise")
	private String nom;
	
	private String logo;
	
	@ManyToOne
	@JoinColumn(name = "id_voilier", referencedColumnName = "id_voilier")
	private Voilier voilier;
	
	public static ArrayList<String> getAttributes(){
		ArrayList<String> r = new ArrayList<>();
		
		for(Field f : Entreprise.class.getDeclaredFields()){
			r.add(f.getName());
		}
		
		return r;
	}
	
	public ArrayList<String> getAttributesValues() {
		ArrayList<String> r = new ArrayList<>();
		
		r.add(String.valueOf(this.id));
		r.add(this.nom);
		r.add(logo);
		r.add(this.voilier.getNom());
		
		return r;
	}
	

}
