package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;

import java.util.List;

public interface IPersonaService extends BaseService<Persona,Long>{

    List<Persona> search(String filter) throws Exception;
}
