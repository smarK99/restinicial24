package com.example.inicial1.repositories;

import com.example.inicial1.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    //filtramos un nombre o un apellido y encuentra las concidencias
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    //Usando query jpql basandonos en las entidades de java
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filter% OR p.apellido LIKE %:filter%")
    List<Persona> search(@Param("filter") String filter);

    //Usando querys sql nativas basandonos en las tablas de la bdd
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filter% OR p.apellido LIKE %:filter%",
            nativeQuery = true
    )
    List<Persona> nativeSearch(@Param("filter") String filter);

    //boolean existsByDni(int dni);

}