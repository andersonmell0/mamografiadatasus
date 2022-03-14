package com.philipsdevweek.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Incidencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
    private Integer regiao_id;
    private Integer mes;
    private Long faixa_id;
    private Integer qnt_exames;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getRegiao_id() {
		return regiao_id;
	}
	public void setRegiao_id(Integer regiao_id) {
		this.regiao_id = regiao_id;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Long getFaixa_id() {
		return faixa_id;
	}
	public void setFaixa_id(Long faixa_id) {
		this.faixa_id = faixa_id;
	}
	public Integer getQnt_exames() {
		return qnt_exames;
	}
	public void setQnt_exames(Integer qnt_exames) {
		this.qnt_exames = qnt_exames;
	}
	
	public Incidencia() {
		super();
	}
        
}