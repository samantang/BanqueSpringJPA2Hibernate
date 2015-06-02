package com.saliou.banque.test;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.saliou.banque.entities.Client;
import com.saliou.banque.entities.CompteCourant;
import com.saliou.banque.entities.CompteEpargne;
import com.saliou.banque.entities.Employe;
import com.saliou.banque.entities.Groupe;
import com.saliou.banque.entities.Retrait;
import com.saliou.banque.entities.Role;
import com.saliou.banque.entities.User;
import com.saliou.banque.entities.Versement;
import com.saliou.banque.metier.ISupMetier;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext(new String []{"applicationContext.xml"});
		ISupMetier metier = (ISupMetier) context.getBean("metierSup");
//		metier.addEmploye(new Employe("E1"), null);
		Employe emp = new Employe("admin1", "admin1", true, null, "E1", null);
		metier.addEmploye(emp, null);
		metier.addRole(new Role("ROLE_ADMIN_SUP", emp));
//		metier.addEmploye(new Employe("E2"), 1L);
//		metier.addEmploye(new Employe("E3"), 1L);
//		metier.addClientByEmploye(new Client("cli1", "add1"), new CompteCourant("cc1", new Date(), 10), 2L);
//		metier.addClientByEmploye(new Client("cli1", "add2"), new CompteEpargne("cdecpt2", new Date(), 20, 2.5), 2L);
		metier.addClientByEmploye(new Client("client1", "client1", true, "nomClient1", "addresseClient1"),
				new CompteCourant(new Date(), 100,"cc1", 554), 1L);
//		
//		metier.addGroupe(new Groupe("G1"));
//		metier.addGroupe(new Groupe("G2"));
//		metier.addEmployeToGroupe(1L, 1L);
//		metier.addEmployeToGroupe(2L, 2L);
		
		
//		metier.addOperationByEmploye(new Versement(new Date(), 10), "cc1", 1L);
//		metier.addOperationByEmploye(new Retrait(new Date(), 5), "cc1", 1L);
//		metier.verser(15, "cc1", 2L);
//		metier.retrait(2, "cc1", 2L);
//		
//		metier.addUser(new User("admin1", "admin1", true));
//		metier.addUser(new User("admin2", "admin2", true));
		
//		metier.addRole(new Role(null, "ROLE_ADMIN_SUP", null));
//		metier.addRole(new Role(1L, "ROLE_ADMIN_EMP"));
//		metier.addRole(new Role(1L, "ROLE_ADMIN_CLI"));
//		
//		metier.addRole(new Role(2L, "ROLE_ADMIN_EMP"));
//		metier.addRole(new Role(null, "ROLE_ADMIN_EMP"));
	}

}
