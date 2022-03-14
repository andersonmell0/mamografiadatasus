package com.philipsdevweek.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.philipsdevweek.model.FaixaEtaria;
import com.philipsdevweek.service.FaixaEtariaService;

@RestController
@RequestMapping("/api/faixaetaria")
public class FaixaEtariaController {	
	
	@Autowired
	private FaixaEtariaService service;
	
	@GetMapping("/faixasestarias")
	public ResponseEntity<?> get() {
		
		try {
			List<FaixaEtaria> lista = service.buscarTodos();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FaixaEtaria> getById(@PathVariable Long id) {
		Optional<FaixaEtaria> optional = service.buscarPorId(id);
		if (optional.isPresent()) {
			FaixaEtaria objetoSelecionado = optional.get();
			return new ResponseEntity<FaixaEtaria>(objetoSelecionado, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/novo")
	public FaixaEtaria post(@RequestBody FaixaEtaria faixaEtaria) {
		return service.salvar(faixaEtaria);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		service.deletar(id);
	}
}