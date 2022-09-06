package com.viniciusgomes.restapispringmongodb.services;

import com.viniciusgomes.restapispringmongodb.models.Post;
import com.viniciusgomes.restapispringmongodb.repositories.PostRepository;
import com.viniciusgomes.restapispringmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);

        return post.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public List<Post> findByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }

    public List<Post> search(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);

        return repository.search(text, minDate, maxDate);
    }
}
