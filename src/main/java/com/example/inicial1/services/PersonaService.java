package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements BaseService<Persona> {

    @Autowired
    private PersonaRepository personaRepository;

    @Transactional
    @Override
    public List<Persona> findAll() throws Exception {
        try {
            return personaRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Persona findById(Long id) throws Exception {
        try {
            Optional<Persona> persona = personaRepository.findById(id);
            return persona.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Persona save(Persona entity) throws Exception {
        try {
           return personaRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Persona update(Long id, Persona entity) throws Exception {
        try {
            Optional<Persona> personaOptional = personaRepository.findById(id);
            Persona persona = personaOptional.get();
            persona = personaRepository.save(entity);
            return persona;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Boolean delete(Long id) throws Exception {
        try {
            if (personaRepository.existsById(id)){
                personaRepository.deleteById(id);
                return true;
            }
            else {
                throw new Exception("No existe la entidad");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
