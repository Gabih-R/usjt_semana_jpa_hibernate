package br.usjt.usjt_semana_jpa_hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.usjt_semana_jpa_hibernate.model.PrevisaoTempo;
import br.usjt.usjt_semana_jpa_hibernate.model.repository.PrevisaoTempoRepository;

@Service
public class PrevisaoTempoService {
	
	@Autowired
	private PrevisaoTempoRepository repo;
	
	public List<PrevisaoTempo> listarPrevisoes() {
		List<PrevisaoTempo> previsoes = repo.findAll();
		return previsoes;
	}
	
	public void salvar(PrevisaoTempo previsao) {
		repo.save(previsao);
	}
	
	public void excluir(PrevisaoTempo previsao) {
		repo.delete(previsao);
	}
}