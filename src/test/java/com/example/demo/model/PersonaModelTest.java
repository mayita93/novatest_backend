package com.example.demo.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonaModelTest {
	
	PersonaModel personaModel;
	private String nombre = "MAYRA";
	
	@Before
	public void init() {
		personaModel = PersonaModel.builder()
				.Nombres(nombre)
				.Apellidos("YAIMA")
				.NumeroIdentificacion("1234")
				.Correo("prt@gmail.com")
				.Activo(true)
				.build();
	}

	@Test
	public void personaModelTest() {
		Assert.assertNotNull(personaModel);
	}	
	
	@Test
	public void PersonaModelNameTest() {
		Assert.assertEquals(nombre, personaModel.getNombres() );
	}
	
	
	@Test
	public void NewPersonaModelTest() {
		
		PersonaModel newPersonaModel = PersonaModel.builder()
				.Nombres(nombre)
				.Apellidos("YAIMA")
				.NumeroIdentificacion("1234")
				.Correo("prt@gmail.com")
				.Activo(true)
				.build();
		
		Assert.assertNotNull(newPersonaModel);	
	}		
	
	
	
}