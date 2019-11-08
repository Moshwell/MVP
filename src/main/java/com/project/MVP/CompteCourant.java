package com.project.MVP;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class CompteCourant {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcc")
    private Integer idcc;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="intitule")
	private String intitule;
	
	@Column(name="solde")
	private double solde;
	
	@Column(name="decouvert")
	private double decouvert;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="client", nullable=true)
	private Client client;

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
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String toString() {
		return "Numero : "+ this.numero + " - Intitule : " + this.intitule + " - Solde : " + this.solde +
				" - Decouvert autorisé : " + this.decouvert;
	}
}
