package com.viniciusgomes.restapispringmongodb.repositories;

import com.viniciusgomes.restapispringmongodb.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> { }
