package com.philipsdevweek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philipsdevweek.model.FaixaEtaria;
import com.philipsdevweek.repository.FaixaEtariaRepository;

@Service
public class FaixaEtariaService {
	
	@Autowired
	private FaixaEtariaRepository repository;
	
	public List<FaixaEtaria> buscarTodos() {
		return repository.findAll();
	}
	
	public Optional<FaixaEtaria> buscarPorId(Long id) {
		return repository.findById(id);
	}

	public FaixaEtaria salvar(FaixaEtaria faixaEtaria) {
		 return repository.save(faixaEtaria);		
	}
		
	public void deletar(Long id) {
		repository.deleteById(id);		
	}

}