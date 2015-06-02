package com.saliou.banque.metier;

import java.util.List;

import com.saliou.banque.entities.Client;
import com.saliou.banque.entities.Compte;
import com.saliou.banque.entities.Operation;

public interface IClientMetier {
	
	public Compte consulterCompte(Long codeCompte);
	public Client getClientByID(Long id);
	public Compte addVirementByClient(Long codeCpte1, Long codeCpte2, double mt);
	public Long getUserId(String name);
	public Client getClientById(Long idEmp);
	public Long getcodeCompteByNom(String nomCompte);
	public void virement(double mt, Long codeCpte1, Long cdeCpte2);
	public List<Operation> consulterOperations(Long cod, int i, int j);
	public Compte getCompteByCodeCompte(Long cod);

}
