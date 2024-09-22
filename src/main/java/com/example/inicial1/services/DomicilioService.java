package com.example.inicial1.services;

import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.repositories.DomicilioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService implements BaseService<Domicilio> {

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Transactional
    @Override
    public List<Domicilio> findAll() throws Exception {
        try {
            return domicilioRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Domicilio findById(Long id) throws Exception {
        try {
            Optional<Domicilio> domicilio = domicilioRepository.findById(id);
            return domicilio.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Domicilio save(Domicilio entity) throws Exception {
        try {
            return domicilioRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Domicilio update(Long id, Domicilio entity) throws Exception {
        try {
            Optional<Domicilio> persona = domicilioRepository.findById(id);
            return domicilioRepository.save(persona.get());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Boolean delete(Long id) throws Exception {
        try {
            if (domicilioRepository.existsById(id)){
                domicilioRepository.deleteById(id);
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
