package com.saliou.banque.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE", discriminatorType=DiscriminatorType.STRING, length=6)
public class Compte implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeCompte;
	private Date dateCreation;
	private double solde;
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client; // un compte concerne un client
	@ManyToOne
	@JoinColumn(name="CODE_EMP")
	private Employe employe; // un compte est cree par un employe
	@OneToMany (mappedBy="compte") // comme l'association est bidirectionnele on utilise mappaBy
	private Collection<Operation> operation; // un compte peut subir plusieurs operations
	private String nomCompte;
//	/**
//	 * @param codeCompte
//	 * @param dateCreation
//	 * @param solde
//	 */
//	public Compte(String codeCompte, Date dateCreation, double solde) {
//		super();
//		this.codeCompte = codeCompte;
//		this.dateCreation = dateCreation;
//		this.solde = solde;
//		
//	}
	/**
	 * 
	 */
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
//	/**
//	 * @return the codeCompte
//	 */
//	public String getCodeCompte() {
//		return codeCompte;
//	}
//	/**
//	 * @param codeCompte the codeCompte to set
//	 */
//	public void setCodeCompte(String codeCompte) {
//		this.codeCompte = codeCompte;
//	}
	
	
	/**
	 * @return the dateCreation
	 */
	public Date getDateCreation() {
		return dateCreation;
	}
	/**
	 * @return the codeCompte
	 */
	public Long getCodeCompte() {
		return codeCompte;
	}


	/**
	 * @param codeCompte the codeCompte to set
	 */
	public void setCodeCompte(Long codeCompte) {
		this.codeCompte = codeCompte;
	}


	/**
	 * @return the nomCompte
	 */
	public String getNomCompte() {
		return nomCompte;
	}


	/**
	 * @param nomCompte the nomCompte to set
	 */
	public void setNomCompte(String nomCompte) {
		this.nomCompte = nomCompte;
	}


	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}
	/**
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}
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
	/**
	 * @return the operation
	 */
	public Collection<Operation> getOperation() {
		return operation;
	}
	/**
	 * @param operation the operation to set
	 */
	public void setOperation(Collection<Operation> operation) {
		this.operation = operation;
	}
	/**
	 * @param dateCreation
	 * @param solde
	 */
	public Compte(Date dateCreation, double solde) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
	}
	/**
	 * @param codeCompte
	 * @param dateCreation
	 * @param solde
	 */
	public Compte(Long codeCompte, Date dateCreation, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}
	/**
	 * @param dateCreation
	 * @param solde
	 * @param nomCompte
	 */
	public Compte(Date dateCreation, double solde, String nomCompte) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.nomCompte = nomCompte;
	}
	
	
		
}
