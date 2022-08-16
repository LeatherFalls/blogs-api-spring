package com.viniciusgomes.restapispringmongodb.controllers;

import com.viniciusgomes.restapispringmongodb.models.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @GetMapping
    public ResponseEntity<UserModel> findAll() {
        UserModel test = new UserModel(1, "Maria", "maria@gmail.com", "123456");
        return ResponseEntity.ok().body(test);
    }
}
