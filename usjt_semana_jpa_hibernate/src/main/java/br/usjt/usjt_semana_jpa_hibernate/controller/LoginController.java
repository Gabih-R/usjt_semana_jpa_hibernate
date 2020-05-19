package br.usjt.usjt_semana_jpa_hibernate.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.usjt_semana_jpa_hibernate.model.Usuario;
import br.usjt.usjt_semana_jpa_hibernate.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@GetMapping ( value = { "/login", "/" } )
	public ModelAndView login() {
		return new ModelAndView("login").addObject(new Usuario());
	}
	
	@PostMapping ("/logar")
	public String logar(HttpServletRequest request, Usuario usuario) {
		if(service.logar(usuario)) {
			request.getSession().setAttribute("usuarioLogado", usuario);
			return "redirect:/previsao";
		}
		return "login";
	}
	
}