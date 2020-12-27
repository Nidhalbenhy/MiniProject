package com.ts.consult.salaries.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalariesCriteria {
	
	@JsonProperty("nom")
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public SalariesCriteria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalariesCriteria(String nom) {
		super();
		this.nom = nom;
	}
	
	

}
