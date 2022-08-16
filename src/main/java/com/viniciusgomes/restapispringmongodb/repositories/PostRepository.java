package com.viniciusgomes.restapispringmongodb.repositories;

import com.viniciusgomes.restapispringmongodb.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> { }
