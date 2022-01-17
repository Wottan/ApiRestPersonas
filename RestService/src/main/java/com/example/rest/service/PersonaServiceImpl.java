package com.example.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rest.dao.IPersonaDao;
import com.example.rest.entity.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDao personaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findPersona(Persona persona) {
		return personaDao.findByNombre(persona.getNombre());
	}

	@Override
	@Transactional
	public void deletePersona(Persona persona) {
		personaDao.deleteById(persona.getId());

	}

	@Override
	@Transactional
	public Optional<Persona> findPersonaById(Long id) {
		return personaDao.findById(id);
	}

	@Override
	@Transactional
	public void deletePersona(Long id) {
		personaDao.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Persona findByID(Long id) {
		// TODO Auto-generated method stub
		return personaDao.findById(id).orElse(null);
	}

	@Override
	public Persona findeBySqlId(Long id) {
		return personaDao.findByIdSQL(id);
	}

	@Override
	@Transactional
	public Persona updatePersona(Persona persona) {
		return (Persona) personaDao.save(persona);
	}

	@Override
	@Transactional
	public void save(Persona persona) {
		personaDao.save(persona);

	}

	@Override
	public void deleteAllPersona() {
		personaDao.deleteAll();
	}

}
