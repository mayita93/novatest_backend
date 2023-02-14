package com.example.demo.controller;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.Assert;
import com.example.demo.model.PersonaModel;
import com.example.demo.service.PersonaService;

public class PersonaControllerTest {

	@InjectMocks
	PersonaController personaController;

	@Mock
	PersonaService personaService;
	
	private ArrayList<PersonaModel> listResponse;
	private PersonaModel modelResponse;	
	private int IdRol = 1;
	private String numeroIdentificacion = "11105523";	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		//Armar resultado esperado
		ArrayList<PersonaModel> listResponse= new ArrayList<PersonaModel>();
		modelResponse = PersonaModel.builder()
				.Nombres("MAYRA ALEJANDRA")
				.Apellidos("YAIMA YATE")
				.Correo("mayra@gmail.com")
				.Activo(true)
				.NumeroIdentificacion(numeroIdentificacion)
				.build();
		listResponse.add(modelResponse);		
	}
	
	@Test
	public void GetPersonasTest() {
		Mockito.when(personaService.GetPersonas() )
		.thenReturn(listResponse);
		Assert.assertEquals(listResponse , personaController.GetPersonas());		
	}
	
	@Test
	public void getByDocumentNumberTest() {

		Mockito.when(personaService.getByDocumentNumber(numeroIdentificacion) )
		.thenReturn(modelResponse);
	
		Assert.assertEquals(numeroIdentificacion ,
				personaController.getByDocumentNumber(numeroIdentificacion).getNumeroIdentificacion() );		
	}
	
	@Test
	public void GetPersonasTipoTest() {

		Mockito.when(personaService.GetPersonasTipo(IdRol))
		.thenReturn(listResponse);
	
		Assert.assertEquals(listResponse ,
				personaController.GetPersonasTipo(IdRol) );	
	}	
	
	@Test
	public void AddPersonaTest() {
		
		PersonaModel modelPersona = PersonaModel.builder()
				.Nombres("ALEJANDRA")
				.Apellidos("YATE")
				.NumeroIdentificacion("111089")
				.Correo("prueba@gmail.com")
				.RolId(1)
				.Activo(true)
				.build();	
		
		Mockito.when(personaService.AddPersona(modelPersona) )
		.thenReturn(modelPersona);		
	
		Assert.assertEquals(modelPersona ,
				personaController.AddPersona(modelPersona));	
	}	

	
}
