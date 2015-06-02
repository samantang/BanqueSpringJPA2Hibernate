package com.saliou.banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="CLIENTS")
@DiscriminatorValue(value="CLIENT")
public class Client extends User implements  Serializable {
	
	@Column(name="CODE_CLI" )
	
//	@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
//	@Value("#{idUser['com.saliou.banque.entities.User']}")
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codeClient;
	private String nomClient;
	private String adresseClient;
	@OneToMany(mappedBy="client", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Collection<Compte>comptes; // un client peut avoir plusieurs comptes
	
	@ManyToOne
	@JoinColumn(name="CODE_EMP")
	private Employe employe;
	@OneToMany(mappedBy="client")
	private Collection<Operation> operation;
	
	
	
	
	
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
	 * @param nomClient
	 * @param adresseClient
	 */
	public Client(String nomClient, String adresseClient) {
		super();
		this.nomClient = nomClient;
		this.adresseClient = adresseClient;
	}
	/**
	 * 
	 */
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the codeClient
	 */
	public Long getCodeClient() {
		return codeClient;
	}
	/**
	 * @param codeClient the codeClient to set
	 */
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	/**
	 * @return the nomClient
	 */
	public String getNomClient() {
		return nomClient;
	}
	/**
	 * @param nomClient the nomClient to set
	 */
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	/**
	 * @return the adresseClient
	 */
	public String getAdresseClient() {
		return adresseClient;
	}
	/**
	 * @param adresseClient the adresseClient to set
	 */
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	/**
	 * @return the comptes
	 */
	public Collection<Compte> getComptes() {
		return comptes;
	}
	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	/**
	 * @param username
	 * @param password
	 * @param actived
	 * @param nomClient
	 * @param adresseClient
	 */
	public Client(String username, String password, boolean actived,
			String nomClient, String adresseClient) {
		super(username, password, actived);
		this.nomClient = nomClient;
		this.adresseClient = adresseClient;
	}
	/**
	 * @param username
	 * @param password
	 * @param actived
	 * @param codeClient
	 * @param nomClient
	 * @param adresseClient
	 */
	public Client(String username, String password, boolean actived,
			Long codeClient, String nomClient, String adresseClient) {
		super(username, password, actived);
		this.codeClient = codeClient;
		this.nomClient = nomClient;
		this.adresseClient = adresseClient;
	}
	
	
	

}
