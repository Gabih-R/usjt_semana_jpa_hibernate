package br.usjt.usjt_semana_jpa_hibernate.model.repository;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import br.usjt.usjt_semana_jpa_hibernate.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	@Async
	public Future <Cidade> findByLatitudeAndLongitude(String latitude, String longitude);
	
	@Async
	public Future <Cidade> findByNome(String nome);
	
	@Async
	public CompletableFuture<Cidade> findByNomeIgnoreCase(String nome);
	
	@Query("SELECT c FROM Cidade c WHERE latitude = :lat AND longitude = :long")
	public Cidade buscarPorLatitudeELongitude(@Param("lat") String latitude, @Param("long") String longitude);
	
	@Query("SELECT c FROM Cidade c WHERE nome = :nome")
	public Cidade buscaPorNome(@Param("nome") String nome);
	
	@Query("SELECT c FROM Cidade c WHERE nome = :nome AND nome LIKE %:nome%")
	public Cidade buscaPorNomeIgnoreCase(@Param("nome") String nome);
	
	public Cidade buscarLatLongPorNamedQuery(@Param("lat") String latitude, @Param("long") String longitude);
	
	public Cidade buscarCidadePorNomeNamedQuery(@Param("nome") String nome);
	
	public Cidade buscarPorNomeIgnoreCaseNamedQuery(@Param("nome") String nome);
}
