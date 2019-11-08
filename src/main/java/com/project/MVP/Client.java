package com.project.MVP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	private String nom;
	
	private String prenom;
	
	//private CompteEpargne ce;
	
	//private CompteCourant cc;
	

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

    public Client(String pNom, String pPrenom) {

	    nom = pNom;
	    prenom = pPrenom;
    }
/*
	double calculerAvoirGlobal() {

		return this.cc.getSolde() + this.ce.getSolde();
	}

	public String toString() {
		return "Nom : "+ this.nom + " - Prenom" + this.prenom + " - Compte Epargne : " + this.ce.toString() +
				" - Compte courant : " + this.cc.toString();
	}
	
*/
}
