package com.example.demo.service;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.PersonaModel;
import com.example.demo.repository.PersonaRepository;

@ExtendWith(MockitoExtension.class)
public class PersonaServiceTest {
	
	@Mock
	private PersonaRepository personaRepository;
	
	@InjectMocks
	private PersonaService personaService;
	
	private ArrayList<PersonaModel> listResponse;
	private PersonaModel model;	
	
	private int IdRol = 1;
	private String numeroIdentificacion = "11105523";
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		//Armar resultado esperado
		ArrayList<PersonaModel> listResponse= new ArrayList<PersonaModel>();
		model = PersonaModel.builder()
				.Nombres("MAYRA ALEJANDRA")
				.Apellidos("YAIMA YATE")
				.NumeroIdentificacion(numeroIdentificacion)
				.Correo("mayra@gmail.com")
				.RolId(IdRol)
				.Activo(true)
				.build();
		listResponse.add(model);
	}
		
	@Test
	public void GetPersonasTest() {
		Mockito.when(personaRepository.findAll())
		.thenReturn(listResponse);
		Assert.assertEquals(listResponse , personaService.GetPersonas());
	}
	
	@Test
	public void GetPersonasTipoTest() {
		
		int idRolBusqueda = IdRol;		
		Mockito.when(personaRepository.getPersonByTipo(idRolBusqueda) )
		.thenReturn(listResponse);
		Assert.assertEquals(listResponse , personaService.GetPersonasTipo(idRolBusqueda));
	}	
	
	@Test
	public void getByDocumentNumberTest() {
		
		Mockito.when(personaRepository.getByDocumentNumber(numeroIdentificacion) )
		.thenReturn(model);
	
		Assert.assertEquals(numeroIdentificacion ,
				personaService.getByDocumentNumber(numeroIdentificacion).getNumeroIdentificacion() );
	}		
	
	
	@Test
	public void AddPersonaTest() {
		
		PersonaModel modelPersona = PersonaModel.builder()
				.Nombres(model.getNombres())
				.Apellidos(model.getApellidos())
				.NumeroIdentificacion(model.getNumeroIdentificacion())
				.Correo(model.getCorreo())
				.RolId(model.getRolId())
				.Activo(model.isActivo())
				.build();		
		
		Mockito.when(personaRepository.save(modelPersona) )
		.thenReturn(model);
	
		Assert.assertEquals(modelPersona ,
				personaService.AddPersona(modelPersona) );
	}		
	

}
