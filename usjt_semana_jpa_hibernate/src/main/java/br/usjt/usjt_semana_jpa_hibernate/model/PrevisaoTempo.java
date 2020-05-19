package br.usjt.usjt_semana_jpa_hibernate.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PrevisaoTempo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(unique=true, name="id_dia")
	private Dia dia;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cidade")
	private Cidade cidade;
	
	private Integer tempMinima;
	private Integer tempMaxima;
	private Integer umidadeRelativaAr;
	private String descricao;
	private String dataHora;
	
	public PrevisaoTempo(Dia dia) {
		this.dia = dia;
		this.dia.setPrevisao(this);
	}

	public PrevisaoTempo() {
	}
	
	public PrevisaoTempo(Dia dia, Cidade cidade, Integer tempMinima, Integer tempMaxima, Integer umidadeRelativaAr, String descricao,
			String dataHora) {
		super();
		this.tempMinima = tempMinima;
		this.tempMaxima = tempMaxima;
		this.umidadeRelativaAr = umidadeRelativaAr;
		this.descricao = descricao;
		this.dataHora = dataHora;
		this.dia = dia;
		this.dia.setPrevisao(this);
		this.cidade = cidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public Integer getTempMinima() {
		return tempMinima;
	}

	public void setTempMinima(Integer tempMinima) {
		this.tempMinima = tempMinima;
	}

	public Integer getTempMaxima() {
		return tempMaxima;
	}

	public void setTempMaxima(Integer tempMaxima) {
		this.tempMaxima = tempMaxima;
	}

	public Integer getUmidadeRelativaAr() {
		return umidadeRelativaAr;
	}

	public void setUmidadeRelativaAr(Integer umidadeRelativaAr) {
		this.umidadeRelativaAr = umidadeRelativaAr;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrevisaoTempo other = (PrevisaoTempo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}