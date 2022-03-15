package com.devsuperior.dsposts.services;

import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.dsposts.dto.UserDTO;
import com.devsuperior.dsposts.entities.User;
import com.devsuperior.dsposts.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        List<User> users = repository.findAll();
        return users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    }

}