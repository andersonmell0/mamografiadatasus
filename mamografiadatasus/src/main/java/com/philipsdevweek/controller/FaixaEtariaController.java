package com.philipsdevweek.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.philipsdevweek.model.FaixaEtaria;
import com.philipsdevweek.repository.FaixaEtariaRepository;

@RestController("/api/faixaetaria")
public class FaixaEtariaController {

	@Autowired
	private FaixaEtariaRepository repository;
	
	@GetMapping("/faixasestarias")
	public List<FaixaEtaria> getRegioes() {
		return repository.findAll();
	}
	
	@GetMapping("/faixaetaria/{id}")
	public ResponseEntity<FaixaEtaria> getFaixaEtariaById(@PathVariable Long id) {
		Optional<FaixaEtaria> faixaEtariaOptional = repository.findById(id);
		if (faixaEtariaOptional.isPresent()) {
			FaixaEtaria faixaEtariaSelecionada = faixaEtariaOptional.get();
			return new ResponseEntity<FaixaEtaria>(faixaEtariaSelecionada, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/salvar")
	public void postFaixaEtaria(FaixaEtaria faixaEtaria) {
		repository.save(faixaEtaria);
	}
}