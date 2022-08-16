package com.viniciusgomes.restapispringmongodb.services;

import com.viniciusgomes.restapispringmongodb.controllers.UserRepository;
import com.viniciusgomes.restapispringmongodb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}
