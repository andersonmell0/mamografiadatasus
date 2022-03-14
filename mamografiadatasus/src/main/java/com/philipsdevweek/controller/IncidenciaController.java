package com.philipsdevweek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.philipsdevweek.repository.IncidenciaRepository;

@RestController("/api/incidencia")
public class IncidenciaController {

	@Autowired
	private IncidenciaRepository repository;
}