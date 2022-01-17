package com.example.rest.service;

import java.util.List;
import java.util.Optional;

import com.example.rest.entity.Persona;

public interface IPersonaService {

	public List<Persona> findAll();

	public Persona findPersona(Persona persona);

	public void deletePersona(Persona persona);

	public Optional<Persona> findPersonaById(Long id);

	public void deletePersona(Long id);

	public Persona updatePersona(Persona persona);

	public Persona findByID(Long id);

	public Persona findeBySqlId(Long id);

	public void save(Persona persona);
}
