package com.example.inicial1.services;

import com.example.inicial1.entities.Localidad;
import com.example.inicial1.repositories.LocalidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadService implements BaseService<Localidad> {
    @Autowired
    private LocalidadRepository localidadRepository;

    @Transactional
    @Override
    public List<Localidad> findAll() throws Exception {
        try {
            return localidadRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Localidad findById(Long id) throws Exception {
        try {
            Optional<Localidad> localidad = localidadRepository.findById(id);
            return localidad.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Localidad save(Localidad entity) throws Exception {
        try {
            return localidadRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Localidad update(Long id, Localidad entity) throws Exception {
        try {
            Optional<Localidad> localidad = localidadRepository.findById(id);
            return localidadRepository.save(localidad.get());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Boolean delete(Long id) throws Exception {
        try {
            if (localidadRepository.existsById(id)){
                localidadRepository.deleteById(id);
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
