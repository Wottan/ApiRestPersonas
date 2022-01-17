package com.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entity.Persona;
import com.example.rest.service.IPersonaService;

@RestController
@RequestMapping("/api")
public class PersonaRestController {

	@Autowired
	private IPersonaService personaService;

	@GetMapping("/personas")
	@ResponseStatus(HttpStatus.OK)
	public List<Persona> getProfesores() {
		return personaService.findAll();
	}

	@PostMapping("/create")
	public ResponseEntity<Void> addPersona(@RequestBody Persona persona) {
		if (personaService.findPersona(persona) == null) {
			personaService.save(persona);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Void> updatePersona(@RequestBody Persona persona) {
		if (personaService.findPersona(persona) == null) {
			personaService.save(persona);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}

}
