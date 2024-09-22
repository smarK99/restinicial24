package com.example.inicial1.services;

import com.example.inicial1.entities.Libro;
import com.example.inicial1.repositories.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService implements BaseService<Libro>{
    @Autowired
    private LibroRepository libroRepository;

    @Transactional
    @Override
    public List<Libro> findAll() throws Exception {
        try {
            return libroRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Libro findById(Long id) throws Exception {
        try {
            Optional<Libro> persona = libroRepository.findById(id);
            return persona.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Libro save(Libro entity) throws Exception {
        try {
            return libroRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Libro update(Long id, Libro entity) throws Exception {
        try {
            Optional<Libro> persona = libroRepository.findById(id);
            return libroRepository.save(persona.get());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Boolean delete(Long id) throws Exception {
        try {
            if (libroRepository.existsById(id)){
                libroRepository.deleteById(id);
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
