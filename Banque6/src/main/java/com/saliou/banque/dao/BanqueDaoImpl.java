/**
 * 
 */
package com.saliou.banque.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.saliou.banque.entities.Client;
import com.saliou.banque.entities.Compte;
import com.saliou.banque.entities.CompteCourant;
import com.saliou.banque.entities.CompteEpargne;
import com.saliou.banque.entities.Employe;
import com.saliou.banque.entities.Groupe;
import com.saliou.banque.entities.Operation;
import com.saliou.banque.entities.Role;
import com.saliou.banque.entities.User;

/**
 * @author salioubah
 *
 */
public class BanqueDaoImpl implements IBanqueDao {
	
	@PersistenceContext
	private EntityManager em;

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#consulterCompte(java.lang.String)
	 */
	@Override
	public Compte consulterCompte(Long codeCompte) {
		Compte cp = em.find(Compte.class, codeCompte);
		return cp;
	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#addVirementByClient(java.lang.Long, com.saliou.banque.entities.Compte, com.saliou.banque.entities.Compte, double)
	 */
	@Override
	public Compte addVirementByClient(Long codeCpte1,Long codeCpte2,
			 double mt) {
		Compte cp = em.find(Compte.class, codeCpte1);
		Compte cp2 = em.find(Compte.class, codeCpte2);
		
		cp.setSolde(cp.getSolde()-mt);
		cp2.setSolde(cp2.getSolde()+mt);
		
		return cp;
	}
	@Override
	public Operation addOperationByClient(Operation op, Long code){
		Compte cp1= consulterCompte(code);
		op.setCompte(cp1);
		em.persist(op);
		return op;
		
	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#addOperationByEmploye(com.saliou.banque.entities.Operation, java.lang.String, java.lang.Long)
	 */
	@Override
	public Operation addOperationByEmploye(Operation op, Long codeCompt,
			Long codeEmp) {
		Compte cp = consulterCompte(codeCompt);
		Employe emp = em.find(Employe.class, codeEmp);
		op.setCompte(cp);
		op.setEmploye(emp);
		
		em.persist(op);
		
		return op;
	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#addClientByEmploye(com.saliou.banque.entities.Client, com.saliou.banque.entities.Compte, java.lang.Long)
	 */
	@Override
	public Client addClientByEmploye(Client cli, Compte cp, Long codeEmp) {
		Employe emp= em.find(Employe.class, codeEmp);
		em.persist(cli);
		em.persist(cp);
		cp.setClient(cli);
//		cli.getComptes().add(cp);
		cli.setEmploye(emp);
//		emp.getClients().add(cli);
		return cli;
	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#consulterOperations(java.lang.String, int, int)
	 */
	@Override
	public List<Operation> consulterOperations(Long codeCpte, int position,
			int nbOperation) {
		Query req=em.createQuery("select o from Operation o where o.compte.codeCompte=:x order by o.dateOperation desc");
		req.setParameter("x", codeCpte);
		req.setFirstResult(position);
		req.setMaxResults(nbOperation);
		return req.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#consulterClient(java.lang.Long)
	 */
	@Override
	public Client consulterClient(Long codeCli) {
		Client c = em.find(Client.class, codeCli);
		if(c==null) throw new RuntimeException("client introuvable");
		return c;
	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#consulterClients(java.lang.String)
	 */
	@Override
	public List<Client> consulterClients(String motCle) {
		Query req = em.createQuery("select c from client c where c.nomClient like :x");
		req.setParameter("x","%"+ motCle+"%");
		return req.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#getEmployes()
	 */
	@Override
	public List<Employe> getEmployes() {
		Query req = em.createQuery("select e from Employe e");
		return req.getResultList();	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#getGroupes()
	 */
	@Override
	public List<Groupe> getGroupes() {
		Query req = em.createQuery("select g from Groupe g");
		System.out.println("nous sommes dans le dao");
		return req.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#getEmployesByGroupe(java.lang.Long)
	 */
	@Override
	public List<Employe> getEmployesByGroupe(Long codeGr) {
		Query req= em.createQuery("select e from Employe where e.groupes.codeGroupe = :x");
		req.setParameter("x", codeGr);
		return req.getResultList();	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#getNombreOperaion(java.lang.String)
	 */
	@Override
	public long getNombreOperaion(String numCompte) {
		Query req= em.createQuery("select count(o) from Operation o where o.compte.codeCompte=:x");
		req.setParameter("x", numCompte);
		return (Long)req.getResultList().get(0);	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#AdClientByEmpl(com.saliou.banque.entities.Client, com.saliou.banque.entities.Compte, java.lang.Long)
	 */
	@Override
	public Client AdClientByEmpl(Client cli, Compte cp, Long IdEmp) {
		Employe emp= em.find(Employe.class, IdEmp);
		em.persist(cli);
		em.persist(cp);
		cli.setEmploye(emp);
		emp.getClients().add(cli);
		return cli;	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#getComptesByClient(java.lang.Long)
	 */
	@Override
	public List<Compte> getComptesByClient(Long CodeCli) {
		Query req = em.createQuery("select c from compte c where c.codeClient= :x");
		req.setParameter("x", CodeCli);
		return req.getResultList();	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#getClients()
	 */
	@Override
	public List<Client> getClients() {
		Query req = em.createQuery("select c from Client c");
		return req.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#addEmploye(com.saliou.banque.entities.Employe, java.lang.Long)
	 */
	@Override
	public Employe addEmploye(Employe e, Long codeSup) {
		if(codeSup!=null){
			Employe sup=em.find(Employe.class,codeSup);
			e.setEmployeSup(sup);
		}
		em.persist(e);
		return e;
	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#addGroupe(com.saliou.banque.entities.Groupe)
	 */
	@Override
	public Groupe addGroupe(Groupe g) {
		em.persist(g);
		return g;	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#addEmployeToGroupe(java.lang.Long, java.lang.Long)
	 */
	@Override
	public void addEmployeToGroupe(Long codeEmp, Long CodeGr) {
		Employe e = em.find(Employe.class, codeEmp);
		Groupe g = em.find(Groupe.class, CodeGr);
		e.getGroupes().add(g);
		g.getEmployes().add(e);


	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#addEmployeSup(java.lang.Long, java.lang.String)
	 */
	@Override
	public Employe addEmployeSup(Long codeEmp, String nomEmp) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#nombreDeGroupes()
	 */
	@Override
	public long nombreDeGroupes() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#addCompte(com.saliou.banque.entities.Compte, java.lang.Long, java.lang.Long)
	 */
	@Override
	public Compte addCompte(Compte cp, Long codeCli, Long codeEm) {
		Client cli = em.find(Client.class, codeCli);
		Employe emp = em.find(Employe.class, codeEm);
		cp.setClient(cli);
		cp.setEmploye(emp);
		em.persist(cp);
		
		return cp;
	}

	

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#getComptes()
	 */
	@Override
	public List<Compte> getComptes() {
		Query req = em.createQuery("from Compte");
		return req.getResultList();	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#getNombreOperaionGroupe(java.lang.String)
	 */
	@Override
	public long getNombreOperaionGroupe(String nomGroupe) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#consulterGroupes(long, int, int)
	 */
	@Override
	public List<Groupe> consulterGroupes(long codeGroupe, int pos, int nbOp) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#getClientById(java.lang.Long)
	 */
	@Override
	public Client getClientById(Long co) {
		Client cli = em.find(Client.class, co);
		return cli;
	}

	/* (non-Javadoc)
	 * @see com.saliou.banque.dao.IBanqueDao#getCompteBycode(java.lang.String)
	 */
	@Override
	public Compte getCompteBycode(String code) {
		Compte cp = em.find(Compte.class, code);
		return cp;	
		}

	@Override
	public Groupe getGetGoupeByCode(long codeGroupe) {
		// TODO Auto-generated method stub
		return em.find(Groupe.class, codeGroupe);
	}

	@Override
	public Employe getEmployeByCode(Long codeEmp) {
		// TODO Auto-generated method stub
		return em.find(Employe.class, codeEmp);
	}

	@Override
	public List<CompteCourant> getCompteCourant() {
		Query req = em.createQuery("from CompteCourant");
		return req.getResultList();
	}

	@Override
	public List<CompteEpargne> getComptesEpargnes() {
		Query req = em.createQuery("from CompteEpargne");
		return req.getResultList();
	}

	@Override
	public Client getClientByID(Long id) {
		Client cli = em.find(Client.class, id);
		return cli;
	}

	@Override
	public User addUser(User user) {
		em.persist(user);
		return null;
	}

	@Override
	public void addRole(Role role) {
		em.persist(role);
		
	}

	@Override
	public Long getUserId(String name) {
		String req = (" select u.idUser from User u where u.username='"+name+"'" );
		return em.createQuery(req, Long.class).getSingleResult();
		
	}

	@Override
	public Long getcodeCompteByNom(String nomCompte) {
		String req=("select c.codeCompte from Compte c where c.nomCompte ='"+nomCompte+"'");
		return em.createQuery(req, Long.class).getSingleResult();
	}

	@Override
	public Compte getCompteByCodeCompte(Long cod) {
		Compte cp = em.find(Compte.class, cod);
		return cp;
	}

	
	
	
}
	
