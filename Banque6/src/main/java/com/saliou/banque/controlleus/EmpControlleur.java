package com.saliou.banque.controlleus;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.saliou.banque.entities.Client;
import com.saliou.banque.entities.Compte;
import com.saliou.banque.entities.CompteCourant;
import com.saliou.banque.entities.CompteEpargne;
import com.saliou.banque.entities.Employe;
import com.saliou.banque.entities.Groupe;
import com.saliou.banque.metier.IEmpMetier;
import com.saliou.banque.models.FormEmp;

@Controller
@RequestMapping("/empl")
@SessionAttributes({"formEmp", "nomEmp", "idEmp"})
public class EmpControlleur {
	
	@Autowired
	@Qualifier("metierEmp")
	private IEmpMetier metier;
	
	@RequestMapping("/index")
	public String index(Model model, FormEmp form){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
	      String name = auth.getName();
	      System.out.println("le nom de l'utilisateur est "+name);
	      Long id = metier.getUserId(name);
	      
	      System.out.println("l'id de l'utilisateur est "+id);
	      
	      model.addAttribute("nomEmp", name);
	      model.addAttribute("idEmp", id);

		model.addAttribute("formEmp", form);
		
		return "index";
	}
	
	@RequestMapping("addClient")
	public String addClient(Model model, FormEmp form){
		if(form.getCodeEmpl()==null){
			List<Client>clients=metier.getClients();
			
			model.addAttribute("clients", clients);
			model.addAttribute("form", form);
			return "addClient";
		}
			if(form.getCompteCourant()!=null){
				Compte cpt = new CompteCourant( new Date(), form.getSoldeCompte(), form.getDecouvert());
				
				Client cli = new Client(form.getNomClient(), form.getAdresseClient());
						
				Client client = metier.addClientByEmploye(cli, cpt, form.getCodeEmpl());
				List<Client>clients=metier.getClients();
				
				model.addAttribute("cp", cpt);
				model.addAttribute("cli", cli);
				model.addAttribute("clients", clients);
				model.addAttribute("form", form);
			}
			if(form.getCompteEpargne()!=null){
				Compte cp = new CompteEpargne( new Date(), form.getSoldeCompte(), form.getTaux());
				Client cli = new Client(form.getNomClient(), form.getAdresseClient());
						
				Client client = metier.addClientByEmploye(cli, cp, form.getCodeEmpl());
				List<Client>clients=metier.getClients();
				
				model.addAttribute("cp", cp);
				model.addAttribute("cli", cli);
				model.addAttribute("clients", clients);
				model.addAttribute("form", form);
			}
		

		return "addClient";
	}
	
	@RequestMapping("addToClient")
	public String addToClient (Model model, FormEmp form, BindingResult br){
		if(form.getCode()==null){
			
			form.setClients(metier.getClients());
			List<Client>clients=metier.getClients();
			
			model.addAttribute("clients", clients);
			model.addAttribute("form", form);
			return "addToClient";
		}
		if(form.getCompteCourant()!=null){
			Compte cp = new CompteCourant( new Date(), form.getSoldeCompte(),form.getNomCompte(), form.getDecouvert());
			Compte compte = metier.addCompte(cp, form.getCodeClient(), form.getCodeEmpl());
		}
		if(form.getCompteEpargne()!=null){
			Compte cp = new CompteEpargne( new Date(), form.getSoldeCompte(),form.getNomCompte(), form.getTaux());
			Compte compte = metier.addCompte(cp, form.getCodeClient(), form.getCodeEmpl());
		}
		form.setClients(metier.getClients());
		model.addAttribute("comptes", metier.getComptes());
		model.addAttribute("form", form);
		return "addToClient";	
	}
	
	@RequestMapping("showClients")
	public String showClients (Model model, FormEmp form){
		List<Client>clients = metier.getClients();
		
		model.addAttribute("clients", clients);
		return "showClients";
		
	}
	
	@RequestMapping("clientDetails")
	public String clientDetails(Model model, FormEmp form, HttpServletRequest request){
		String code = request.getParameter("code");
		Long co = Long.parseLong(code);
		Client cli = metier.getClientById(co);	
		
		model.addAttribute("client", cli);
		return "clientDetails";
	}
	
	@RequestMapping("showComptes")
	public String showComptes(Model model, FormEmp form){
		form.setComptes(metier.getComptes());
		
		model.addAttribute("form", form);
		return "showComptes";
	}
	
	@RequestMapping("compteDetail")
	public String compteDetail (Model model, FormEmp form, HttpServletRequest re){
		String code = re.getParameter("code");
		Long cod = Long.parseLong(code);
		form.setOperations(metier.consulterOperations(cod, 0, 0));
		form.setComptes(metier.getComptes());
		
		model.addAttribute("form", form);
		return "compteDetail";
		
	}
	
	@RequestMapping("operations")
	public String operations (Model model, FormEmp form, HttpServletRequest re){
		String code = re.getParameter("code");
		Long cod = Long.parseLong(code);
		form.setOperations(metier.consulterOperations(cod, 0, 0));
		form.setCompte(metier.getCompteByCodeCompte(cod));
		form.setComptes(metier.getComptes());
		form.setCode(re.getParameter("code"));
		
		model.addAttribute("form", form);
		return "operations";
		
	}
	
	@RequestMapping(value="/saveOperation")
	public String saveOp(@Valid FormEmp form, BindingResult bindingResult, Model model, HttpServletRequest re){
		
		try {
			if(bindingResult.hasErrors())
				return "banque";
			if(form.getAction()!=null){
			if(form.getTypeOperation().equals("VER")){
				metier.verser(form.getMontant(), form.getCodeCompte(), 1L);
				
			}else if(form.getTypeOperation().equals("RET")){
				metier.retrait(form.getMontant(), form.getCodeCompte(), 1L);
				
			}else if(form.getTypeOperation().equals("VIR")){
				metier.virement(form.getMontant(), form.getCodeCompte(), form.getCodeCompte2(), 1L);
			}
			}
		} catch (Exception e) {
			form.setException(e.getMessage());
		}
		chargerCompte(form, re);

		model.addAttribute("form", form);
		return("operations");
	}
	
	public void chargerCompte(FormEmp form, HttpServletRequest re){
		try {
			
			form.setOperations(metier.consulterOperations(form.getCodeCompte(), 0, 0));
			form.setComptes(metier.getComptes());
			
//			Compte cp= metier.consulterCompte(bf.getCode());
//			bf.setTypeCompte(cp.getClass().getSimpleName());
//			bf.setCompte(cp);
//			int pos=bf.getNbLignes()*bf.getPage();
//			List<Operation>ops=metier.consulterOperations(bf.getCode(), pos, 5);
//			bf.setOperations(ops);
//			long nbOp=metier.getNombreOperaion(bf.getCode());
//			bf.setNombrePages((int)(nbOp/bf.getNbLignes())+1);
			
		} catch (Exception e) {
			form.setException(e.getMessage());
		}

	}
	
	@RequestMapping("getEmployes")
	public String getEmployes (Model model, FormEmp form){
		form.setEmployes(metier.getEmployes());
		
		model.addAttribute("form", form);
		return "getEmployes";
		
	}
	@RequestMapping(value="employeDetails")
	public String employeDetails(Model model, FormEmp form, HttpServletRequest request){
		String code=request.getParameter("code");
		long codeEmp = Long.valueOf(code);
		form.setEmploye(metier.getEmployeByCode(codeEmp));
		
		model.addAttribute("form", form);
		return "employeDetails";
		
	}
	
	@RequestMapping("/getGoupes")
	public String getGoupes (Model model, FormEmp form){
		form.setGroupes(metier.getGroupes());
		List<Groupe> groupes = metier.getGroupes();
		List<Employe> emp = metier.getEmployes();
		
		if(groupes !=null){
			for(Groupe g : groupes){
				System.out.println("le groupe  "+g.getNomGroupe());
			}
		}
			
			if(emp != null){
				for(Employe e : emp){
					System.out.println("employ�   "+e.getNomEmploye());
				}
			
			}
			
		
		model.addAttribute("form", form);
		return "getGoupes";
		
	}
	
	@RequestMapping(value="groupeDtail")
	public String groupeDtail (Model model, FormEmp form, HttpServletRequest request){
		String code= request.getParameter("code");
//		Long codeGroupe= Long.valueOf(code);
		long codeGroupe = Long.parseLong(code);
		long codeG= Long.valueOf(code);
		form.setGroupe(metier.getGetGoupeByCode(codeG));
		
		
		model.addAttribute("form", form);
		return "groupeDtail";
		
	}
		
		@RequestMapping("comptesCourants")
		public String comptesCourants (Model model, FormEmp form){
			form.setComptesCourant(metier.getCompteCourant());
			
			model.addAttribute("form", form);
			return "comptesCourants";
			
		}
		
		@RequestMapping("comptesEpargnes")
		public String comptesEpargnes (Model model, FormEmp form){
			form.setComptesEpargnes(metier.getComptesEpargnes());
			
			model.addAttribute("form", form);
			return "comptesEpargnes";
			
		}
}
