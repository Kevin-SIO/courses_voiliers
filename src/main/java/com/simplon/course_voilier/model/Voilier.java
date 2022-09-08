package com.simplon.course_voilier.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Voilier")
public class Voilier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_voilier")
	private int id;
	@Column(name="nom_voilier")
	private String nom;
	private int longeur;
	private int largeur;
	@OneToMany(mappedBy = "voilier")
	private List<Entreprise> entreprise;
}
