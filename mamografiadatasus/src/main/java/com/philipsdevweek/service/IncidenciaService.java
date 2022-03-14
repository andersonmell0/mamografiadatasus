package com.philipsdevweek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philipsdevweek.model.Incidencia;
import com.philipsdevweek.repository.IncidenciaRepository;

@Service
public class IncidenciaService {
	
	@Autowired
	private IncidenciaRepository repository;
	
	public List<Incidencia> buscarTodos() {
		return repository.findAll();		
	}

	public void deletar(Long id) {
		repository.deleteById(id);		
	}

	public Incidencia salvar(Incidencia incidencia) {
		return repository.save(incidencia);		
	}

	public Optional<Incidencia> buscarPorId(Long id) {
		return repository.findById(id);		 
	}

}