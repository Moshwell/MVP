package com.project.MVP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompteCourant {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idcc;
	
	private String numero;
	
	private String intitule;
	
	private double solde;
	
	private double decouvert;

	public Integer getIdCc() {
		return idcc;
	}

	public void setIdCc(Integer idCc) {
		this.idcc = idCc;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	void debiter(double a) {
		this.solde = this.solde - a;
	}
	
	void crediter(double a) {
		this.solde = this.solde + a;
	}

	public CompteCourant (String intit, double sold, double decouv){
        intitule = intit;
        solde = sold;
        decouvert = decouv;
    }

	public String toString() {
		return "Numero : "+ this.numero + " - Intitule" + this.intitule + " - Solde : " + this.solde +
				" - Decouvert autorisé : " + this.decouvert;
	}
}
