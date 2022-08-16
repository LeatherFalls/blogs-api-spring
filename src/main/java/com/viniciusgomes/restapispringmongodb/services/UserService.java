package com.viniciusgomes.restapispringmongodb.services;

import com.viniciusgomes.restapispringmongodb.controllers.UserRepository;
import com.viniciusgomes.restapispringmongodb.dto.UserDTO;
import com.viniciusgomes.restapispringmongodb.services.exception.ObjectNotFoundException;
import com.viniciusgomes.restapispringmongodb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public User create(User user) {
        return repository.save(user);
    }

    public User fromDTO(UserDTO userdto) {
        return new User(userdto.getId(), userdto.getName(), userdto.getEmail(), userdto.getPassword());
    }
}
