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

import com.philipsdevweek.model.Regiao;
import com.philipsdevweek.repository.RegiaoRepository;

@RestController("/api/regiao")
public class RegiaoController {

	@Autowired
	private RegiaoRepository repository;
	
	/*
	 * public void ControllerRegiao(RegiaoRepository repository) { this.repository =
	 * repository; }
	 */
	
	@GetMapping("/regioes")
	public List<Regiao> getRegioes() {
		return repository.findAll();
	}
	
	@GetMapping("/regiao/{id}")
	public ResponseEntity<Regiao> getRegiaoById(@PathVariable Long id) {
		Optional<Regiao> regiaoOptional = repository.findById(id);
		if (regiaoOptional.isPresent()) {
			Regiao regiaoSelecionada = regiaoOptional.get();
			return new ResponseEntity<Regiao>(regiaoSelecionada, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public void postRegiao(Regiao regiao) {
		repository.save(regiao);
	}
}