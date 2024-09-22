package com.example.inicial1.services;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.repositories.AutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements BaseService<Autor>{
    @Autowired
    private AutorRepository autorRepository;

    @Transactional
    @Override
    public List<Autor> findAll() throws Exception {
        try {
            return autorRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Autor findById(Long id) throws Exception {
        try {
            Optional<Autor> autor = autorRepository.findById(id);
            return autor.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Autor save(Autor entity) throws Exception {
        try {
            return autorRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Autor update(Long id, Autor entity) throws Exception {
        try {
            Optional<Autor> persona = autorRepository.findById(id);
            return autorRepository.save(persona.get());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Boolean delete(Long id) throws Exception {
        try {
            if (autorRepository.existsById(id)){
                autorRepository.deleteById(id);
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
