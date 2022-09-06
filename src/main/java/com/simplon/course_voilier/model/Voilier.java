package com.simplon.course_voilier.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
