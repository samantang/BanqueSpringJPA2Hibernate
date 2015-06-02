package com.saliou.banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value="R")
public class Retrait extends Operation{

	/**
	 * 
	 */
	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dateOperation
	 * @param montant
	 */
	public Retrait(Date dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Retrait";
	}

}
