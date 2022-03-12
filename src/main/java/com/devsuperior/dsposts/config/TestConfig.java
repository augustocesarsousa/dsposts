package com.devsuperior.dsposts.config;

import java.time.Instant;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.devsuperior.dsposts.embedded.Author;
import com.devsuperior.dsposts.embedded.Comment;
import com.devsuperior.dsposts.entities.Post;
import com.devsuperior.dsposts.entities.User;
import com.devsuperior.dsposts.repositories.PostRepository;
import com.devsuperior.dsposts.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @PostConstruct
    public void init() {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User sushi = new User(null, "Sushi Sousa", "sushi@gmail.com");
        User thor = new User(null, "Thor Sousa", "thor@gmail.com");
        User nino = new User(null, "Nino Oliveira", "nino@gmail.com");

        userRepository.saveAll(Arrays.asList(sushi, thor, nino));

        Post post1 = new Post(null, Instant.parse("2021-02-13T11:15:01Z"), "Partiu viagem",
                "Vou viajar para São Paulo. Abraços!", new Author(sushi));
        Post post2 = new Post(null, Instant.parse("2021-02-14T10:05:49Z"), "Bom dia", "Acordei feliz hoje!",
                new Author(sushi));

        Comment comment1 = new Comment("Boa viagem mano!", Instant.parse("2021-02-13T14:30:01Z"), new Author(thor));
        Comment comment2 = new Comment("Aproveite", Instant.parse("2021-02-13T15:38:05Z"), new Author(nino));
        Comment comment3 = new Comment("Tenha um ótimo dia!", Instant.parse("2021-02-14T12:34:26Z"), new Author(thor));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().addAll(Arrays.asList(comment3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        sushi.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(sushi);
    }

}