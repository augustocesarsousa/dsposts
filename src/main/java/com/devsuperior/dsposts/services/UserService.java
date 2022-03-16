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
        User user = getEntityById(id);
        return new UserDTO(user);
    }

    public UserDTO insert(UserDTO userDTO) {
        User user = new User();
        copyDtoToUser(userDTO, user);
        user = repository.insert(user);
        return new UserDTO(user);
    }

    public UserDTO update(String id, UserDTO userDTO) {
        User user = getEntityById(id);
        copyDtoToUser(userDTO, user);
        user = repository.save(user);
        return new UserDTO(user);
    }

    public void delete(String id) {
        getEntityById(id);
        repository.deleteById(id);
    }

    private User getEntityById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    private void copyDtoToUser(UserDTO userDTO, User user) {
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
    }
}