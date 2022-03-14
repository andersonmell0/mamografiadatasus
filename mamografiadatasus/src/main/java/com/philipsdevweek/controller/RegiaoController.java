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

import com.philipsdevweek.model.Regiao;
import com.philipsdevweek.service.RegiaoService;

@RestController
@RequestMapping("/api/regiao")
public class RegiaoController {
	
	@Autowired
	private RegiaoService service;
	
	@GetMapping("/regioes")
	public ResponseEntity<?> get() {
		try {
			List<Regiao> lista = service.buscarTodos(); 
			return new ResponseEntity<>(lista, HttpStatus.OK);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Regiao> getById(@PathVariable Long id) {
		Optional<Regiao> optional = service.buscarPorId(id);
		if (optional.isPresent()) {
			Regiao objetoSelecionado = optional.get();
			return new ResponseEntity<Regiao>(objetoSelecionado, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/novo")
	public Regiao post(@RequestBody Regiao regiao) {
		return service.salvar(regiao);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		service.deletar(id);
	}
}