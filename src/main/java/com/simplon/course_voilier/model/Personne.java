package com.simplon.course_voilier.model;

import java.util.ArrayList;
import java.util.Date;

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
@Table(name="personne")
public class Personne implements Model{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_personne")
	private int id;

	@Column(name="nom_personne")
	private String nom;
	private String prenom;

	@Column(name="date_de_naissance")
	private Date dateNaissance;
	
	@ManyToOne
	@JoinColumn(name="id_type_role",referencedColumnName = "id_type_role")
	private TypeRole role;

	@ManyToOne
	@JoinColumn(name="id_equipage",referencedColumnName = "id_equipage")
	private Equipage equipage;
 
	public ArrayList<String> getAttributesValues() {
		ArrayList<String> r = new ArrayList<>();
		
		r.add(String.valueOf(this.id));
		r.add(this.nom);
		r.add(String.valueOf(this.dateNaissance));
		r.add(this.role.getNom());
		r.add(this.equipage.getNom());
		
		return r;
	}
	
	public static ArrayList<String> getAttributes(){
		return Model.getAttributes(Personne.class);
	}
	
	public static ArrayList<String> getAttributesType() {
		return Model.getAttributesClass(Personne.class);
	}

}
