package com.saliou.banque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)

public class Operation implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numeroOperation;
	private Date dateOperation;
	private double montant;
	@ManyToOne
	@JoinColumn(name="CODE_CPTE") //  clee etrangère
	private Compte compte; // une operation appartient à un compte
	@ManyToOne
	@JoinColumn(name="CODE_EMP") // clee etrangère
	private Employe employe; // une operation est cree par un employe
	
	@ManyToOne
	@JoinColumn(name="OP_CLI")
	private Client client;
	
	
	
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	/**
	 * 
	 */
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param dateOperation
	 * @param montant
	 */
	public Operation(Date dateOperation, double montant) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
	}
	/**
	 * @return the numeroOperation
	 */
	public Long getNumeroOperation() {
		return numeroOperation;
	}
	/**
	 * @param numeroOperation the numeroOperation to set
	 */
	public void setNumeroOperation(Long numeroOperation) {
		this.numeroOperation = numeroOperation;
	}
	/**
	 * @return the dateOperation
	 */
	public Date getDateOperation() {
		return dateOperation;
	}
	/**
	 * @param dateOperation the dateOperation to set
	 */
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	/**
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}
	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}
	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	/**
	 * @return the employe
	 */
	public Employe getEmploye() {
		return employe;
	}
	/**
	 * @param employe the employe to set
	 */
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	

}
