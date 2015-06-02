package com.saliou.banque.controlleus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginControlleur {
	
	@RequestMapping(value="/login")
	public String login (){
		return "login";
		
	}
	@RequestMapping(value="/logout")
	public String logout (Model model,HttpServletRequest req){
		HttpSession session = req.getSession();
//		session.getAttribute("");
//		session.invalidate();
		if(session!=null){
			session.invalidate();
		}
		return "/login";
		
	}
}
