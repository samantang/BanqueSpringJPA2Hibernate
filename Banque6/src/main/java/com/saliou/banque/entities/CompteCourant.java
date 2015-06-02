package com.saliou.banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue ("CC") // comme cette classe herite de la classe compte
// alors si on cree une classe compteCourant, la colonne TYPE_CPT definie dans la classe
// compte sera "cc"
public class CompteCourant extends Compte{
	private double decouvert;

	/**
	 * 
	 */
	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

//	/**
//	 * @param codeCompte
//	 * @param dateCreation
//	 * @param solde
//	 */
//	public CompteCourant(String codeCompte, Date dateCreation, double solde) {
//		super(codeCompte, dateCreation, solde);
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @param codeCompte
//	 * @param dateCreation
//	 * @param solde
//	 * @param decouvert
//	 */
//	public CompteCourant(String codeCompte, Date dateCreation, double solde,
//			double decouvert) {
//		super(codeCompte, dateCreation, solde);
//		this.decouvert = decouvert;
//	}

	/**
	 * @return the decouvert
	 */
	public double getDecouvert() {
		return decouvert;
	}

	/**
	 * @param decouvert the decouvert to set
	 */
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	/**
	 * @param dateCreation
	 * @param solde
	 * @param decouvert
	 */
	public CompteCourant(Date dateCreation, double solde, double decouvert) {
		super(dateCreation, solde);
		this.decouvert = decouvert;
	}

	/**
	 * @param codeCompte
	 * @param dateCreation
	 * @param solde
	 * @param decouvert
	 */
	public CompteCourant(Long codeCompte, Date dateCreation, double solde,
			double decouvert) {
		super(codeCompte, dateCreation, solde);
		this.decouvert = decouvert;
	}

	/**
	 * @param dateCreation
	 * @param solde
	 * @param nomCompte
	 * @param decouvert
	 */
	public CompteCourant(Date dateCreation, double solde, String nomCompte,
			double decouvert) {
		super(dateCreation, solde, nomCompte);
		this.decouvert = decouvert;
	}
	
	
	

}
