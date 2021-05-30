package com.thiagoadelino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thiagoadelino.repository.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository repository;

    public void findAll(){
        repository.findAll();
    }

}
