package com.saliou.banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Groupe implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeGroupe;
	private String nomGroupe;
	@ManyToMany (mappedBy="groupes", fetch = FetchType.EAGER, cascade = CascadeType.ALL) // l'association est dejà definie dans la classe employee
	private Collection<Employe> employes;
	/**
	 * @return the codeGroupe
	 */
	public Long getCodeGroupe() {
		return codeGroupe;
	}
	/**
	 * @param codeGroupe the codeGroupe to set
	 */
	public void setCodeGroupe(Long codeGroupe) {
		this.codeGroupe = codeGroupe;
	}
	/**
	 * @return the nomGroupe
	 */
	public String getNomGroupe() {
		return nomGroupe;
	}
	/**
	 * @param nomGroupe the nomGroupe to set
	 */
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	/**
	 * @return the employes
	 */
	public Collection<Employe> getEmployes() {
		return employes;
	}
	/**
	 * @param employes the employes to set
	 */
	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}
	/**
	 * 
	 */
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param nomGroupe
	 */
	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}
	
	
	
}
