package com.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dao.IPersonaDao;
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

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProfesor(@PathVariable(value = "id") Long id, @RequestBody Persona persona) {
		Persona personaDb = null;
		personaDb = personaService.findByID(id);
		if (personaDb != null) {
			personaDb.setApellido(persona.getApellido());
			personaDb.setNombre(persona.getNombre());
			personaDb.setDni(persona.getDni());
			personaDb.setEmpleado(persona.getEmpleado());
			personaService.updatePersona(personaDb);
			return new ResponseEntity<>(personaDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update_sql")
	public ResponseEntity<?> updateProfesorSql(@RequestBody Persona persona) {
		Persona personaDb = null;
		personaDb = personaService.findeBySqlId(persona.getId());
		if (personaDb != null) {
			personaDb.setApellido(persona.getApellido());
			personaDb.setNombre(persona.getNombre());
			personaDb.setDni(persona.getDni());
			personaDb.setEmpleado(persona.getEmpleado());
			personaService.updatePersona(personaDb);
			return new ResponseEntity<>(personaDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deletePersona(@PathVariable(value="id")Long id){
		personaService.deletePersona(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Void> deleteAllPersona(){
		personaService.deleteAllPersona();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
