package com.devsuperior.dsposts.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.devsuperior.dsposts.entities.User;
import com.devsuperior.dsposts.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {

        userRepository.deleteAll();

        User sushi = new User(null, "Sushi Sousa", "sushi@gmail.com");
        User thor = new User(null, "Thor Sousa", "thor@gmail.com");
        User nino = new User(null, "Nino Oliveira", "nino@gmail.com");

        userRepository.saveAll(Arrays.asList(sushi, thor, nino));
    }

}