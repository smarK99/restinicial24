package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona,Long> implements IPersonaService{

    @Autowired//Hay que acceder al repo de persona de alguna manera
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> search(String filter) throws Exception {
        try{
            return personaRepository.findByNombreContainingOrApellidoContaining(filter, filter);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
