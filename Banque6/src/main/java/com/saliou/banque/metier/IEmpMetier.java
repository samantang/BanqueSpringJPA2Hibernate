package com.saliou.banque.metier;

import java.util.List;

import com.saliou.banque.entities.Client;
import com.saliou.banque.entities.Compte;
import com.saliou.banque.entities.CompteCourant;
import com.saliou.banque.entities.CompteEpargne;
import com.saliou.banque.entities.Employe;
import com.saliou.banque.entities.Groupe;
import com.saliou.banque.entities.Operation;

public interface IEmpMetier extends IClientMetier {
	
	public Operation addOperationByEmploye(Operation op, Long codeCompt, Long codeEmp);
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
	public List<Compte> getComptes();
	public Compte addCompte (Compte cp, Long codeCli, Long codeEm);
	public Client getClientById(Long co);
	
	public void verser( double mt, Long long1, long codeEmp);
	public void retrait( double mt,Long codeCpte, long codeEmp);
	public void virement(double mt, Long codeCpte1, Long cdeCpte2,  long codeEmp);
	public Groupe getGetGoupeByCode(long codeGroupe);
	public Employe getEmployeByCode(Long codeEmp);
	public List<CompteCourant> getCompteCourant();
	public List<CompteEpargne> getComptesEpargnes();
}
