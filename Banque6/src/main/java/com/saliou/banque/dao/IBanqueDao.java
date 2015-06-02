package com.saliou.banque.dao;

import java.util.List;

import com.saliou.banque.entities.Client;
import com.saliou.banque.entities.Compte;
import com.saliou.banque.entities.CompteCourant;
import com.saliou.banque.entities.CompteEpargne;
import com.saliou.banque.entities.Employe;
import com.saliou.banque.entities.Groupe;
import com.saliou.banque.entities.Operation;
import com.saliou.banque.entities.Role;
import com.saliou.banque.entities.User;


public interface IBanqueDao {
	
	public Compte consulterCompte(Long codeCpte);
	public Client getClientByID(Long id);
	public Compte addVirementByClient(Long codeCpte1, Long codeCpte2, double mt);
	public Operation addOperationByClient(Operation op, Long code);

	
	public Operation addOperationByEmploye(Operation op, Long codeCpte, Long codeEmp);
	public Client addClientByEmploye(Client cli, Compte cp, Long codeEmp);
	public List<Operation>consulterOperations(Long codeCpte, int position, int nbOperation);
	public Client consulterClient (Long codeCli);
	public List<Client> consulterClients(String motCle);
	public List<Employe> getEmployes();
	public List<Groupe> getGroupes();
	public List<Employe> getEmployesByGroupe(Long codeGr);
	public long getNombreOperaion (String numCompte);
	public Client AdClientByEmpl(Client cli, Compte cp, Long IdEmp);
	public List<Compte> getComptesByClient(Long CodeCli);
	public List<Client> getClients();
	public Compte addCompte (Compte cp, Long codeCli, Long codeEm);
	public List<Compte> getComptes();
	public Client getClientById(Long id);
	public Employe getEmployeByCode(Long codeEmp);
	public List<CompteCourant> getCompteCourant();
	public List<CompteEpargne> getComptesEpargnes();
	
	
	public Employe addEmploye(Employe e, Long codeSup);
	public Groupe addGroupe(Groupe g);
	public void addEmployeToGroupe(Long codeEmp, Long CodeGr);
	public Employe addEmployeSup(Long codeEmp, String nomEmp);
	public long  nombreDeGroupes();
	public long getNombreOperaionGroupe (String nomGroupe);
	public List<Groupe> consulterGroupes(long codeGroupe, int pos, int nbOp);
	public Compte getCompteBycode(String code);
	public Groupe getGetGoupeByCode(long codeGroupe);
	public User addUser(User user);
	public void addRole(Role role);
	public Long getUserId(String name);
	public Long getcodeCompteByNom(String nomCompte);
	public Compte getCompteByCodeCompte(Long cod);


}
