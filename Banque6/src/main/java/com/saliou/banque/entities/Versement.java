package com.saliou.banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation{

	/**
	 * 
	 */
	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dateOperation
	 * @param montant
	 */
	public Versement(Date dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Versement";
	}

}
