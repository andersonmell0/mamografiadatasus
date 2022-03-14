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

import com.philipsdevweek.model.Incidencia;
import com.philipsdevweek.service.IncidenciaService;

@RestController
@RequestMapping("/api/incidencia")
public class IncidenciaController {

	@Autowired
	private IncidenciaService service;
	
	@GetMapping("/incidencias")
	public ResponseEntity<?> get(){
		try {
			List<Incidencia> lista = service.buscarTodos();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Incidencia> getById(@PathVariable Long id) {
		Optional<Incidencia> optional = service.buscarPorId(id);
		if (optional.isPresent()) {
			Incidencia objetoSelecionado = optional.get();
			return new ResponseEntity<Incidencia>(objetoSelecionado, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/novo")
	public Incidencia post(@RequestBody Incidencia incidencia) {
		return service.salvar(incidencia);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		service.deletar(id);
	}
}