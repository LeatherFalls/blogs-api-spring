package com.viniciusgomes.restapispringmongodb.controllers;

import com.viniciusgomes.restapispringmongodb.models.User;
import com.viniciusgomes.restapispringmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserController {
    private final PasswordEncoder encoder;
    @Autowired
    private UserService service;

    public UserController(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }
}
