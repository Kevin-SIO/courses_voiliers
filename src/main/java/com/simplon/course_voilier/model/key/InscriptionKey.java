package com.simplon.course_voilier.model.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class InscriptionKey implements Serializable{

	@Column(name="id_course")
	private int course;
	@Column(name="id_voilier")
	private int voilier;
	@Column(name="id_equipage")
	private int equipage;
}
