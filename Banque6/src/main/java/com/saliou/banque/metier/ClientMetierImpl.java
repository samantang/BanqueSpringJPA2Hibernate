package com.saliou.banque.metier;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.saliou.banque.dao.IBanqueDao;
import com.saliou.banque.entities.Client;
import com.saliou.banque.entities.Compte;
import com.saliou.banque.entities.Operation;
import com.saliou.banque.entities.Retrait;
import com.saliou.banque.entities.Versement;

@Transactional
public class ClientMetierImpl implements IClientMetier {
	
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
		return dao.consulterCompte(codeCompte);
	}

	@Override
	public Compte addVirementByClient(Long codeCpte1, Long codeCpte2, double mt) {
		// TODO Auto-generated method stub
		return dao.addVirementByClient(codeCpte1, codeCpte2, mt);
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
	public Client getClientById(Long idEmp) {
		// TODO Auto-generated method stub
		return dao.getClientById(idEmp);
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
	public List<Operation> consulterOperations(Long cod, int i, int j) {
		// TODO Auto-generated method stub
		return dao.consulterOperations(cod, i, j);
	}

	@Override
	public Compte getCompteByCodeCompte(Long cod) {
		// TODO Auto-generated method stub
		return dao.getCompteByCodeCompte(cod);
	}

}
