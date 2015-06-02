package com.saliou.banque.models;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.saliou.banque.entities.Client;
import com.saliou.banque.entities.Compte;
import com.saliou.banque.entities.CompteCourant;
import com.saliou.banque.entities.CompteEpargne;
import com.saliou.banque.entities.Employe;
import com.saliou.banque.entities.Groupe;
import com.saliou.banque.entities.Operation;


public class FormEmp {
	
	private Client cli;
	private Compte cp;
	private Long idClient;
	private Long codeClient;
	private String nomClient;
	private String adresseClient;
	private double soldeCompte;
	private Date date;
	private Long codeEmpl;
	private List<Compte> comptes;
	private List<Client> clients;
	private String typeCompte ;
	private List<Operation> operations;
	private String exception;
	private String typeOperation;
	private double montant=50;
	private String code2="xxx";
	private String action;
	private double solde;
	private List<Employe> employes;
	private List<Groupe> groupes;
	private String testCompte;
	private double taux;
	private double decouvert;
	private String compteCourant;
	private String compteEpargne;
	private long codeGroupe;
	private Groupe groupe;
	private Employe employe;
	private List<CompteCourant> comptesCourant;
	private List<CompteEpargne> comptesEpargnes;
	private String sessionSup="ma";
	private Long codeSup;
	private String nomEmploye;
	private String nomGoupe;
	private String addGroupe;
	private Client client;
	private String findClient;
	private String userName;
	private String passWord;
	private String nomEmpSup;
	private Long idEmpSup;
	private Long codeCompte;
	private String nomCompte;
	private String code;
	private Long codeCompte2;
	private String nomCompte2;
	private Compte compte;
	
	
	
	
	
	
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
	 * @return the nomCompte2
	 */
	public String getNomCompte2() {
		return nomCompte2;
	}
	/**
	 * @param nomCompte2 the nomCompte2 to set
	 */
	public void setNomCompte2(String nomCompte2) {
		this.nomCompte2 = nomCompte2;
	}
	/**
	 * @return the codeCompte2
	 */
	public Long getCodeCompte2() {
		return codeCompte2;
	}
	/**
	 * @param codeCompte2 the codeCompte2 to set
	 */
	public void setCodeCompte2(Long codeCompte2) {
		this.codeCompte2 = codeCompte2;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the nomEmpSup
	 */
	public String getNomEmpSup() {
		return nomEmpSup;
	}
	/**
	 * @param nomEmpSup the nomEmpSup to set
	 */
	public void setNomEmpSup(String nomEmpSup) {
		this.nomEmpSup = nomEmpSup;
	}
	/**
	 * @return the idEmpSup
	 */
	public Long getIdEmpSup() {
		return idEmpSup;
	}
	/**
	 * @param idEmpSup the idEmpSup to set
	 */
	public void setIdEmpSup(Long idEmpSup) {
		this.idEmpSup = idEmpSup;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the passWord
	 */
	public String getPassWord() {
		return passWord;
	}
	/**
	 * @param passWord the passWord to set
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	/**
	 * @return the findClient
	 */
	public String getFindClient() {
		return findClient;
	}
	/**
	 * @param findClient the findClient to set
	 */
	public void setFindClient(String findClient) {
		this.findClient = findClient;
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
	 * @return the addGroupe
	 */
	public String getAddGroupe() {
		return addGroupe;
	}
	/**
	 * @param addGroupe the addGroupe to set
	 */
	public void setAddGroupe(String addGroupe) {
		this.addGroupe = addGroupe;
	}
	/**
	 * @return the nomGoupe
	 */
	public String getNomGoupe() {
		return nomGoupe;
	}
	/**
	 * @param nomGoupe the nomGoupe to set
	 */
	public void setNomGoupe(String nomGoupe) {
		this.nomGoupe = nomGoupe;
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
	 * @return the codeSup
	 */
	public Long getCodeSup() {
		return codeSup;
	}
	/**
	 * @param codeSup the codeSup to set
	 */
	public void setCodeSup(Long codeSup) {
		this.codeSup = codeSup;
	}
	/**
	 * @return the sessionSup
	 */
	public String getSessionSup() {
		return sessionSup;
	}
	/**
	 * @param sessionSup the sessionSup to set
	 */
	public void setSessionSup(String sessionSup) {
		this.sessionSup = sessionSup;
	}
	/**
	 * @return the comptesEpargnes
	 */
	public List<CompteEpargne> getComptesEpargnes() {
		return comptesEpargnes;
	}
	/**
	 * @param comptesEpargnes the comptesEpargnes to set
	 */
	public void setComptesEpargnes(List<CompteEpargne> comptesEpargnes) {
		this.comptesEpargnes = comptesEpargnes;
	}
	/**
	 * @return the comptesCourant
	 */
	public List<CompteCourant> getComptesCourant() {
		return comptesCourant;
	}
	/**
	 * @param comptesCourant the comptesCourant to set
	 */
	public void setComptesCourant(List<CompteCourant> comptesCourant) {
		this.comptesCourant = comptesCourant;
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
	 * @return the groupe
	 */
	public Groupe getGroupe() {
		return groupe;
	}
	/**
	 * @param groupe the groupe to set
	 */
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	/**
	 * @return the codeGroupe
	 */
	public long getCodeGroupe() {
		return codeGroupe;
	}
	/**
	 * @param codeGroupe the codeGroupe to set
	 */
	public void setCodeGroupe(long codeGroupe) {
		this.codeGroupe = codeGroupe;
	}
	/**
	 * @return the compteCourant
	 */
	public String getCompteCourant() {
		return compteCourant;
	}
	/**
	 * @param compteCourant the compteCourant to set
	 */
	public void setCompteCourant(String compteCourant) {
		this.compteCourant = compteCourant;
	}
	/**
	 * @return the compteEpargne
	 */
	public String getCompteEpargne() {
		return compteEpargne;
	}
	/**
	 * @param compteEpargne the compteEpargne to set
	 */
	public void setCompteEpargne(String compteEpargne) {
		this.compteEpargne = compteEpargne;
	}
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
	 * @return the testCompte
	 */
	public String getTestCompte() {
		return testCompte;
	}
	/**
	 * @param testCompte the testCompte to set
	 */
	public void setTestCompte(String testCompte) {
		this.testCompte = testCompte;
	}
	/**
	 * @return the groupes
	 */
	public List<Groupe> getGroupes() {
		return groupes;
	}
	/**
	 * @param groupes the groupes to set
	 */
	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}
	/**
	 * @return the employes
	 */
	public List<Employe> getEmployes() {
		return employes;
	}
	/**
	 * @param employes the employes to set
	 */
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
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
	 * @return the exception
	 */
	public String getException() {
		return exception;
	}
	/**
	 * @param exception the exception to set
	 */
	public void setException(String exception) {
		this.exception = exception;
	}
	/**
	 * @return the typeOperation
	 */
	public String getTypeOperation() {
		return typeOperation;
	}
	/**
	 * @param typeOperation the typeOperation to set
	 */
	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
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
	 * @return the code2
	 */
	public String getCode2() {
		return code2;
	}
	/**
	 * @param code2 the code2 to set
	 */
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the operations
	 */
	public List<Operation> getOperations() {
		return operations;
	}
	/**
	 * @param operations the operations to set
	 */
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	/**
	 * @return the typeCompte
	 */
	public String getTypeCompte() {
		return typeCompte;
	}
	/**
	 * @param typeCompte the typeCompte to set
	 */
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	/**
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}
	/**
	 * @param clients the clients to set
	 */
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	/**
	 * @return the comptes
	 */
	public List<Compte> getComptes() {
		return comptes;
	}
	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	/**
	 * @return the cli
	 */
	public Client getCli() {
		return cli;
	}
	/**
	 * @param cli the cli to set
	 */
	public void setCli(Client cli) {
		this.cli = cli;
	}
	/**
	 * @return the cp
	 */
	public Compte getCp() {
		return cp;
	}
	/**
	 * @param cp the cp to set
	 */
	public void setCp(Compte cp) {
		this.cp = cp;
	}
	/**
	 * @return the idClient
	 */
	public Long getIdClient() {
		return idClient;
	}
	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
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
	 * @return the soldeCompte
	 */
	public double getSoldeCompte() {
		return soldeCompte;
	}
	/**
	 * @param soldeCompte the soldeCompte to set
	 */
	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the codeEmpl
	 */
	public Long getCodeEmpl() {
		return codeEmpl;
	}
	/**
	 * @param codeEmpl the codeEmpl to set
	 */
	public void setCodeEmpl(Long codeEmpl) {
		this.codeEmpl = codeEmpl;
	}
	

	
}
