package com.simplon.course_voilier.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="nom_entreprise")
	private String nom;
	
	private String logo;
	
//	@ManyToOne
//	private Voilier voilier;
	

}
