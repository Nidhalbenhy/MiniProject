package com.ts.consult.salaries.dto;

public class SalariesDTO {

	private String id;
	private String matricule;
	private String nom;
	private String prenom;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public SalariesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SalariesDTO(String matricule, String nom, String prenom) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
}
