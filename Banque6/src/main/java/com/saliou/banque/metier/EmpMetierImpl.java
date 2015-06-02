package com.saliou.banque.metier;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.saliou.banque.dao.IBanqueDao;
import com.saliou.banque.entities.Client;
import com.saliou.banque.entities.Compte;
import com.saliou.banque.entities.CompteCourant;
import com.saliou.banque.entities.CompteEpargne;
import com.saliou.banque.entities.Employe;
import com.saliou.banque.entities.Groupe;
import com.saliou.banque.entities.Operation;
import com.saliou.banque.entities.Retrait;
import com.saliou.banque.entities.Versement;

@Transactional
public class EmpMetierImpl implements IEmpMetier {
	
	private IBanqueDao dao;
	
	

	/**
	 * @return the dao
	 */
	public IBanqueDao getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(IBanqueDao dao) {
		this.dao = dao;
	}

	@Override
	public Compte consulterCompte(Long codeCompte) {
		// TODO Auto-generated method stub
		return dao.consulterCompte(codeCompte)
				;
	}

	@Override
	public Compte addVirementByClient(Long codeCpte1, Long codeCpte2, double mt) {
		// TODO Auto-generated method stub
		return dao.addVirementByClient(codeCpte1, codeCpte2, mt);
	}

	@Override
	public Operation addOperationByEmploye(Operation op, Long codeCompt,
			Long codeEmp) {
		// TODO Auto-generated method stub
		return dao.addOperationByEmploye(op, codeCompt, codeEmp);
	}

	@Override
	public Client addClientByEmploye(Client cli, Compte cp, Long codeEmp) {
		// TODO Auto-generated method stub
		return dao.addClientByEmploye(cli, cp, codeEmp);
	}

	@Override
	public List<Operation> consulterOperations(Long codeCpte, int position,
			int nbOperation) {
		// TODO Auto-generated method stub
		return dao.consulterOperations(codeCpte, position, nbOperation);
	}

	@Override
	public Client consulterClient(Long codeCli) {
		// TODO Auto-generated method stub
		return dao.consulterClient(codeCli);
	}

	@Override
	public List<Client> consulterClients(String motCle) {
		// TODO Auto-generated method stub
		return dao.consulterClients(motCle);
	}

	@Override
	public List<Employe> getEmployes() {
		// TODO Auto-generated method stub
		return dao.getEmployes();
	}

	@Override
	public List<Groupe> getGroupes() {
		// TODO Auto-generated method stub
		System.out.println("nous sommes dans le metier");
		return dao.getGroupes();
	}

	@Override
	public List<Employe> getEmployesByGroupe(Long codeGr) {
		// TODO Auto-generated method stub
		return dao.getEmployesByGroupe(codeGr);
	}

	@Override
	public long getNombreOperaion(String numCompte) {
		// TODO Auto-generated method stub
		return dao.getNombreOperaion(numCompte);
	}

	@Override
	public Client AdClientByEmpl(Client cli, Compte cp, Long IdEmp) {
		// TODO Auto-generated method stub
		return dao.AdClientByEmpl(cli, cp, IdEmp);
	}

	@Override
	public List<Compte> getComptesByClient(Long CodeCli) {
		// TODO Auto-generated method stub
		return dao.getComptesByClient(CodeCli);
	}

	@Override
	public List<Client> getClients() {
		// TODO Auto-generated method stub
		return dao.getClients();
	}

	@Override
	public List<Compte> getComptes() {
		// TODO Auto-generated method stub
		return dao.getComptes();
	}

	@Override
	public Compte addCompte(Compte cp, Long codeCli, Long codeEm) {
		// TODO Auto-generated method stub
		return dao.addCompte(cp, codeCli, codeEm);
	}

	@Override
	public Client getClientById(Long co) {
		// TODO Auto-generated method stub
		return dao.getClientById(co);
	}

	@Override
	public void verser(double mt, Long codeCpte, long codeEmp) {
		dao.addOperationByEmploye(new Versement(new Date(), mt), codeCpte, codeEmp);
		Compte cp = dao.consulterCompte(codeCpte);
		cp.setSolde(cp.getSolde()+mt);
		
	}

	@Override
	public void retrait(double mt, Long codeCpte, long codeEmp) {
		dao.addOperationByEmploye(new Retrait(new Date(), mt), codeCpte, codeEmp);
		Compte cp = dao.consulterCompte(codeCpte);
		cp.setSolde(cp.getSolde()-mt);
		
	}

	@Override
	public void virement(double mt, Long codeCpte1, Long cdeCpte2,
			long codeEmp) {
		retrait(mt, codeCpte1, codeEmp);
		verser(mt, cdeCpte2, codeEmp);
		
	}

	@Override
	public Groupe getGetGoupeByCode(long codeGroupe) {
		// TODO Auto-generated method stub
		return dao.getGetGoupeByCode(codeGroupe);
	}

	@Override
	public Employe getEmployeByCode(Long codeEmp) {
		// TODO Auto-generated method stub
		return dao.getEmployeByCode(codeEmp);
	}

	@Override
	public List<CompteCourant> getCompteCourant() {
		// TODO Auto-generated method stub
		return dao.getCompteCourant();
	}

	@Override
	public List<CompteEpargne> getComptesEpargnes() {
		// TODO Auto-generated method stub
		return dao.getComptesEpargnes();
	}

	@Override
	public Client getClientByID(Long id) {
		// TODO Auto-generated method stub
		return dao.getClientByID(id);
	}

	@Override
	public Long getUserId(String name) {
		// TODO Auto-generated method stub
		return dao.getUserId(name);
	}

	@Override
	public Long getcodeCompteByNom(String nomCompte) {
		// TODO Auto-generated method stub
		return dao.getcodeCompteByNom(nomCompte);
	}

	@Override
	public void virement(double mt, Long codeCpte1, Long cdeCpte2) {
		retrait(mt, codeCpte1);
		verser(mt, cdeCpte2);
		
	}

	private void verser(double mt, Long cdeCpte2) {
		dao.addOperationByClient(new Versement(new Date(), mt), cdeCpte2);
		Compte cp = dao.consulterCompte(cdeCpte2);
		cp.setSolde(cp.getSolde()+mt);
	}

	private void retrait(double mt, Long codeCpte1) {
		dao.addOperationByClient(new Retrait(new Date(), mt), codeCpte1);
		Compte cp = dao.consulterCompte(codeCpte1);
		cp.setSolde(cp.getSolde()-mt);
		
	}

	@Override
	public Compte getCompteByCodeCompte(Long cod) {
		// TODO Auto-generated method stub
		return dao.getCompteByCodeCompte(cod);
	}

	
	

}
