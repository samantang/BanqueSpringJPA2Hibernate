package com.saliou.banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity
@DiscriminatorValue(value="EMPLOYE")
public class Employe extends User implements Serializable{
	
	
	private Long codeEmplye;
	private String nomEmploye;
	@ManyToOne
	@JoinColumn(name="CODE_EMP_SUP")
	private Employe employeSup;
	@ManyToMany // un employe peut appartenir à plusieurs groupes et un groupe se compose de plusieurs employes
	// dans ce cas une table de jointure sera cree par hibernate
	@JoinTable(name="EMP_GR", joinColumns=
	@JoinColumn(name="CODE_EMP"),
	inverseJoinColumns=@JoinColumn(name="CODE_GR")) // dans cette table deux clees etrangères seront immediatement cree
	private Collection<Groupe>groupes;
	
	@OneToMany(mappedBy="employe",  cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Client> clients;
	
	
	/**
	 * @return the clients
	 */
	public Collection<Client> getClients() {
		return clients;
	}
	/**
	 * @param clients the clients to set
	 */
	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}
	/**
	 * @return the codeEmplye
	 */
	public Long getCodeEmplye() {
		return codeEmplye;
	}
	/**
	 * @param codeEmplye the codeEmplye to set
	 */
	public void setCodeEmplye(Long codeEmplye) {
		this.codeEmplye = codeEmplye;
	}
	/**
	 * @return the nomEmploye
	 */
	public String getNomEmploye() {
		return nomEmploye;
	}
	/**
	 * @param nomEmploye the nomEmploye to set
	 */
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	/**
	 * @return the employeSup
	 */
	public Employe getEmployeSup() {
		return employeSup;
	}
	/**
	 * @param employeSup the employeSup to set
	 */
	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}
	/**
	 * @return the groupes
	 */
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	/**
	 * @param groupes the groupes to set
	 */
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	/**
	 * 
	 */
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param nomEmploye
	 */
	public Employe(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;
	}
	/**
	 * @param username
	 * @param password
	 * @param actived
	 * @param codeEmplye
	 * @param nomEmploye
	 * @param employeSup
	 */
	public Employe(String username, String password, boolean actived,
			Long codeEmplye, String nomEmploye, Employe employeSup) {
		super(username, password, actived);
		this.codeEmplye = codeEmplye;
		this.nomEmploye = nomEmploye;
		this.employeSup = employeSup;
	}
	/**
	 * @param username
	 * @param password
	 * @param actived
	 * @param nomEmploye
	 */
	public Employe(String username, String password, boolean actived,
			String nomEmploye) {
		super(username, password, actived);
		this.nomEmploye = nomEmploye;
	}
	
	
	
	
	
	

}
