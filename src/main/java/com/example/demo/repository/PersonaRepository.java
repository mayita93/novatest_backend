package com.example.demo.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.PersonaModel;

@Repository
public interface PersonaRepository extends CrudRepository<PersonaModel,Integer> {

	@Query(value = "select r.* from persona r where r.Activo = 1 and r.id_rol = :idRol order by r.id desc ", nativeQuery = true)
	ArrayList<PersonaModel> getPersonByTipo(@Param("idRol") int idRol);
	
	@Query(value = "select r.* from persona r where r.Activo = 1 and r.numero_identificacion = :numeroIdentificacion ", nativeQuery = true)
	PersonaModel getByDocumentNumber(@Param("numeroIdentificacion") String numeroIdentificacion);	
	
}
