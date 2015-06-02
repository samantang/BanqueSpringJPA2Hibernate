package com.saliou.banque.controlleus;

import java.text.Normalizer.Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.saliou.banque.entities.Client;
import com.saliou.banque.entities.Compte;
import com.saliou.banque.metier.IClientMetier;
import com.saliou.banque.models.FormEmp;

@Controller
@RequestMapping("/client")
@SessionAttributes({"formClient", "nomCli", "idCli"})
public class ClientControlleur {
	
	@Autowired
	@Qualifier("metierCli")
	private IClientMetier metier;
	
	@RequestMapping("/index")
	public String index(Model model, FormEmp form, HttpServletRequest re){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
	      String name = auth.getName();
	      System.out.println("le nom de l'utilisateur est "+name);
	      Long id = metier.getUserId(name);
	      
	      System.out.println("l'id de l'utilisateur est "+id);
	      
	      model.addAttribute("nomCli", name);
	      model.addAttribute("idCli", id);
	      

		model.addAttribute("formClient", form);
		return "index";
	}
	@RequestMapping("client")
	public String client (Model model, FormEmp form){
		if(form.getFindClient()==null){
			model.addAttribute("form", form);
			return "client";
		}
		form.setClient(metier.getClientByID(form.getIdClient()));
		
		model.addAttribute("form", form);
		return "client";
		
	}
	
	@RequestMapping("myComptes")
	public String myComptes (Model model, HttpServletRequest re){
		HttpSession session = re.getSession();
		Long idEmp =   (Long) session.getAttribute("idCli");
		
		Client cli = metier.getClientById(idEmp);	
		
		model.addAttribute("client", cli);
		return "clientDetails";
		
	}
	@RequestMapping("addOperationCli")
	public String addOperation(Model model, FormEmp form, HttpServletRequest re){
		HttpSession session = re.getSession();
		Long idEmp =   (Long) session.getAttribute("idCli");
		
		Client cli = metier.getClientById(idEmp);			
		form.setCli(cli);
		if(form.getNomCompte2()!=null){
			Long idCp1=metier.getcodeCompteByNom(form.getNomCompte());
			Long idCp2=metier.getcodeCompteByNom(form.getNomCompte2());
			
			metier.virement(form.getMontant(), idCp1, idCp2);
		}
		
		model.addAttribute("client", cli);
		model.addAttribute("form", form);
		
		return "addOperationCli";
		
	}
	
	@RequestMapping("operations")
	public String operations (Model model, FormEmp form, HttpServletRequest re){
//		String code = re.getParameter("code");
//		Long cod = metier.getcodeCompteByNom(code);
//		Compte cp = metier.getCompteByCodeCompte(cod);
//		form.setCompte(cp);
//		form.setOperations(metier.consulterOperations(cod, 0, 0));
////		form.setComptes(metier.getComptes());
////		form.setCode(re.getParameter("code"));
//		form.setCodeCompte(cod);
//		
//		model.addAttribute("form", form);
		
		
		
		String code = re.getParameter("code");
		Long cod = Long.parseLong(code);
		form.setOperations(metier.consulterOperations(cod, 0, 0));
//		form.setComptes(metier.getComptes());
		form.setCode(re.getParameter("code"));
		form.setCodeCompte(cod);
		form.setCompte(metier.getCompteByCodeCompte(cod));
		form.setCompte(metier.getCompteByCodeCompte(cod));
		
		model.addAttribute("form", form);
		return "operations";
	}
}
