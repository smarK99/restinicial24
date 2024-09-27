package com.example.inicial1.services;

import com.example.inicial1.entities.Base;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

//Implementacion abstracta del baseService
public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {

    @Autowired
    protected BaseRepository<E,ID> baseRepository;

    // Quiza tambien tiene que ir el constructor inicializando el base repo

    @Transactional
    @Override
    public List<E> findAll() throws Exception {
        try {
            return baseRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public E findById(ID id) throws Exception {
        try {
            Optional<E> persona = baseRepository.findById(id);
            return persona.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public E save(E entity) throws Exception {
        try {
            return baseRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> optional = baseRepository.findById(id);
            E entityUpdated = optional.get();
            entityUpdated = baseRepository.save(entity);
            return entityUpdated;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Boolean delete(ID id) throws Exception {
        try {
            if (baseRepository.existsById(id)){
                baseRepository.deleteById(id);
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
