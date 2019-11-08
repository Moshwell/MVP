package com.project.MVP;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class CompteEpargne {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idce")
    private Integer idce;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="intitule")
	private String intitule;
	
	@Column(name="solde")
	private double solde;
	
	@Column(name="interet")
	private double interet;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="client", nullable=true)
	private Client client;

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
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String toString() {
		return "Numero : "+ this.numero + " - Intitule : " + this.intitule + " - Solde : " + this.solde +
				" - Taux Interet : " + this.interet;
	}
	
}
