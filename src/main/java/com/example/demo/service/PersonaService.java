package com.example.demo.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.PersonaModel;
import com.example.demo.repository.PersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	PersonaRepository personaRepository;
	
	public ArrayList<PersonaModel> GetPersonas(){
		return (ArrayList<PersonaModel>) personaRepository.findAll();
	}
	
	public ArrayList<PersonaModel> GetPersonasTipo(int idRol){
		return (ArrayList<PersonaModel>) personaRepository.getPersonByTipo(idRol);
	}	
	
	public PersonaModel getByDocumentNumber(String numeroIdentificacion) {
		return personaRepository.getByDocumentNumber(numeroIdentificacion);	
}	
	
	
	public PersonaModel AddPersona(PersonaModel model) {
		return personaRepository.save(model);
	}
	
	
}
