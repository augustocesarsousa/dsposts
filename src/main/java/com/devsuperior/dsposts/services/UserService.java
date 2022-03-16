package com.devsuperior.dsposts.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devsuperior.dsposts.dto.UserDTO;
import com.devsuperior.dsposts.entities.User;
import com.devsuperior.dsposts.repositories.UserRepository;
import com.devsuperior.dsposts.services.exceptions.ResourceNotFoundException;

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

    public UserDTO findById(String id) {
        Optional<User> user = repository.findById(id);
        User entity = user.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return new UserDTO(entity);
    }

}