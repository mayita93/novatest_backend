package com.example.demo.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class PersonaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private int Id;
	
	@Column(name = "id_tipo_identificacion" ,nullable = false)
	private int TipoIdentificacion;
	
	@Column(name = "numero_identificacion" ,nullable = false, length = 20)
	private String NumeroIdentificacion;
	
	@Column(name = "id_rol" ,nullable = false)
	private int RolId;	
	
	@Column(nullable = false, length = 40)
	private String Nombres;

	@Column(nullable = false, length = 40)
	private String Apellidos;
	
	@Column(nullable = false, length = 40)
	private String Correo;
	
	private boolean Activo;
	
}
