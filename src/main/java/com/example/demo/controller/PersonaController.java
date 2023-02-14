package com.example.demo.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.PersonaModel;
import com.example.demo.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	PersonaService personaService;
	
	// listado de personas
	@GetMapping()
	public ArrayList<PersonaModel> GetPersonas(){
		return personaService.GetPersonas();
	}
	
	// validar si existe persona
	@GetMapping("/{numeroIdentificacion}")
	public PersonaModel getByDocumentNumber(@PathVariable("numeroIdentificacion") String numeroIdentificacion) {
			return personaService.getByDocumentNumber(numeroIdentificacion);	
	}
	
	// obtener listado de persona por rol
	@GetMapping("/all")
	public ArrayList<PersonaModel> GetPersonasTipo(int idRol){
		return personaService.GetPersonasTipo(idRol);
	}	
	
	// agregar persona
	@PostMapping()
	public PersonaModel AddPersona(@RequestBody  PersonaModel model ) {
		return personaService.AddPersona(model);
	}
	
}
