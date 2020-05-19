package br.usjt.usjt_semana_jpa_hibernate.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.usjt.usjt_semana_jpa_hibernate.model.PrevisaoTempo;

public interface PrevisaoTempoRepository extends JpaRepository<PrevisaoTempo, Long> {
	
}