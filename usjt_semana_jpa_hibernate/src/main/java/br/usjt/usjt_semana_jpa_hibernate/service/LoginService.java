package br.usjt.usjt_semana_jpa_hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.usjt_semana_jpa_hibernate.model.Usuario;
import br.usjt.usjt_semana_jpa_hibernate.model.repository.UsuarioRepository;

@Service
public class LoginService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public boolean logar(Usuario usuario) {
		return repo.findOneByUserAndPass(usuario.getUser(), usuario.getPass()) != null;
	}
	
}