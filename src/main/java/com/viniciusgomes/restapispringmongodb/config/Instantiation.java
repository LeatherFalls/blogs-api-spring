package com.viniciusgomes.restapispringmongodb.config;

import com.viniciusgomes.restapispringmongodb.dto.AuthorDTO;
import com.viniciusgomes.restapispringmongodb.models.Post;
import com.viniciusgomes.restapispringmongodb.models.User;
import com.viniciusgomes.restapispringmongodb.repositories.PostRepository;
import com.viniciusgomes.restapispringmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String ...arg0) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com", "$2a$08$Z.jGZFfxirBB3S28/ripi.86BnSS4t8RVrMdv1zCcsKGl9c.oiVzW");
        User alex = new User(null, "Alex Green", "alex@gmail.com", "$2a$08$q.OaD7oZ3.h8X9Ho4YOMA.JK8ft6BNhLNnO.UAFMyftlu4YYr2XAq");
        User bob = new User(null, "Bob Grey", "bob@gmail.com", "$2a$08$7IUEeUB0QW4yInPxjJLv6.Mj3K8uCeRKNumDDuGZoKkCjBjE/kHvO");

        userRepository.save(maria);
        userRepository.save(alex);
        userRepository.save(bob);

        Post post1 = new Post(null, sdf.parse("21/03/2022"), "Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("10/04/2022"), "Bom dia!", "Que belo dia!!", new AuthorDTO(alex));

        postRepository.save(post1);
        postRepository.save(post2);
    }
}
