package com.project.MVP;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Client {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@JsonManagedReference
	@OneToMany(mappedBy="client")
	private Set<CompteEpargne> ce;
	
	@JsonManagedReference
	@OneToMany(mappedBy="client")
	private  Set<CompteCourant> cc;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
/*
	double calculerAvoirGlobal() {

		return this.cc.getSolde() + this.ce.getSolde();
	}
*/
	public String toString() {
		return "Nom : "+ this.nom + " - Prenom" + this.prenom + " - Compte Epargne : " + this.ce.toString() +
				" - Compte courant : " + this.cc.toString();
	}
	

}
