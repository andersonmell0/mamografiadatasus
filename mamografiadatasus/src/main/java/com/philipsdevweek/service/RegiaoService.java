package com.philipsdevweek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philipsdevweek.model.Regiao;
import com.philipsdevweek.repository.RegiaoRepository;

@Service
public class RegiaoService {

	@Autowired
	private RegiaoRepository repository;

	public List<Regiao> buscarTodos() {
		return repository.findAll();		
	}

	public Optional<Regiao> buscarPorId(Long id) {		
		return repository.findById(id);
	}

	public Regiao salvar(Regiao regiao) {		
		return repository.save(regiao);
	}

	public void deletar(Long id) {
		repository.deleteById(id);		
	}
		
}