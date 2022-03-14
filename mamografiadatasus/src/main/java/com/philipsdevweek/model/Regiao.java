package com.philipsdevweek.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Regiao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String regiao;
	private Long total_exames;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public Long getTotal_exames() {
		return total_exames;
	}
	public void setTotal_exames(Long total_exames) {
		this.total_exames = total_exames;
	}
	
	public Regiao() {
		super();
	}
	
}