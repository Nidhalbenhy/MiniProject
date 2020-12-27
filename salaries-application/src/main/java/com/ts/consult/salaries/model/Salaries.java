package com.ts.consult.salaries.model;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("salaries")
public class Salaries {
	@Id
	private String id;
	@Column(unique=true)
	private String matricule;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String adresse;
	
	public Salaries() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Salaries(String id) {
		super();
		this.id = id;
	}



	public Salaries(String matricule, String nom, String prenom, Date dateNaissance, String adresse) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}

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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Salaries [ matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + dateNaissance + ", adresse=" + adresse + "]";
	}
	
	
	

}
