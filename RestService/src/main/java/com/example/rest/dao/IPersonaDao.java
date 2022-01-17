package com.example.rest.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.rest.entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long> {

	public Persona findByNombre(String name);

	public Persona findByDni(String dni);

	public Optional<Persona> findById(Long id);

	@Query("select p from Persona p where p.id=?1")
	public Persona findByIdSQL(Long id);

}
