package com.project.MVP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompteEpargne {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idce;
	
	private String numero;
	
	private String intitule;
	
	private double solde;
	
	private double interet;

	public Integer getIdCe() {
		return idce;
	}

	public void setIdCe(Integer idCe) {
		this.idce = idCe;
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

	public double getInteret() {
		return interet;
	}

	public void setInteret(double interet) {
		this.interet = interet;
	}
	
	void debiter(double a) {
		this.solde = this.solde - a;
	}
	
	void crediter(double a) {
		this.solde = this.solde + a;
	}
	
	double calculInteret() {
		return (this.solde * this.interet);
	}
	
	public String toString() {
		return "Numero : "+ this.numero + " - Intitule" + this.intitule + " - Solde : " + this.solde +
				" - Taux Interet : " + this.interet;
	}
	
}
