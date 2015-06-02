package com.saliou.banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	
	private double taux;

	/**
	 * 
	 */
	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

//	/**
//	 * @param codeCompte
//	 * @param dateCreation
//	 * @param solde
//	 */
//	public CompteEpargne(String codeCompte, Date dateCreation, double solde) {
//		super(codeCompte, dateCreation, solde);
//		// TODO Auto-generated constructor stub
//	}

//	/**
//	 * @param codeCompte
//	 * @param dateCreation
//	 * @param solde
//	 * @param taux
//	 */
//	public CompteEpargne(String codeCompte, Date dateCreation, double solde,
//			double taux) {
//		super(codeCompte, dateCreation, solde);
//		this.taux = taux;
//	}

	/**
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}

	/**
	 * @param dateCreation
	 * @param solde
	 * @param taux
	 */
	public CompteEpargne(Date dateCreation, double solde, double taux) {
		super(dateCreation, solde);
		this.taux = taux;
	}

	/**
	 * @param codeCompte
	 * @param dateCreation
	 * @param solde
	 * @param taux
	 */
	public CompteEpargne(Long codeCompte, Date dateCreation, double solde,
			double taux) {
		super(codeCompte, dateCreation, solde);
		this.taux = taux;
	}

	/**
	 * @param dateCreation
	 * @param solde
	 * @param nomCompte
	 * @param taux
	 */
	public CompteEpargne(Date dateCreation, double solde, String nomCompte,
			double taux) {
		super(dateCreation, solde, nomCompte);
		this.taux = taux;
	}
	
	
	
	
	

}
