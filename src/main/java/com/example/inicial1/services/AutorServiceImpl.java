package com.example.inicial1.services;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor,Long> implements IAutorService{
    @Autowired
    private AutorRepository autorRepository;


}
