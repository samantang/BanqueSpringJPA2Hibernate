package com.saliou.banque.controlleus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saliou.banque.models.FormEmp;

@Controller
@RequestMapping("/accueil")
public class Accueil {
	
	
	@RequestMapping("/accueil")
	public String accueil(Model model, FormEmp form){
		
		return "acceuil";
		
	}

}
