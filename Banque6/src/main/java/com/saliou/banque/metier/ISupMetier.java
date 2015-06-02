package com.saliou.banque.metier;

import java.util.List;

import com.saliou.banque.entities.Client;
import com.saliou.banque.entities.Compte;
import com.saliou.banque.entities.Employe;
import com.saliou.banque.entities.Groupe;
import com.saliou.banque.entities.Role;
import com.saliou.banque.entities.User;

public interface ISupMetier extends IEmpMetier {
	
	public Employe addEmploye(Employe e, Long codeSup);
	public Groupe addGroupe(Groupe g);
	public void addEmployeToGroupe(Long codeEmp, Long CodeGr);
	public Employe addEmployeSup(Long codeEmp, String nomEmp);
	public long  nombreDeGroupes();
	public Compte addCompte (Compte cp, Long codeCli, Long codeEm);
	public List<Groupe> getGoupes();
	public List<Compte> getComptes();
	public long getNombreOperaionGroupe (String nomGroupe);
	public List<Groupe> consulterGroupes(long codeGroupe, int pos, int nbOp);
	public Client getClientById(Long co);
	public Compte getCompteBycode(String code);
	public User addUser(User user);
	public void addRole(Role role);
	public Long getUserId(String name);
}
