package br.usjt.usjt_semana_jpa_hibernate.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.usjt_semana_jpa_hibernate.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Usuario findOneByUserAndPass(String user, String pass);
	
}