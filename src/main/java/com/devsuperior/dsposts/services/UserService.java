package com.devsuperior.dsposts.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devsuperior.dsposts.dto.PostDTO;
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
        User user = getUserById(id);
        return new UserDTO(user);
    }

    public UserDTO insert(UserDTO userDTO) {
        User user = new User();
        copyDtoToUser(userDTO, user);
        user = repository.insert(user);
        return new UserDTO(user);
    }

    public UserDTO update(String id, UserDTO userDTO) {
        User user = getUserById(id);
        copyDtoToUser(userDTO, user);
        user = repository.save(user);
        return new UserDTO(user);
    }

    public void delete(String id) {
        getUserById(id);
        repository.deleteById(id);
    }

    public List<PostDTO> getUserPosts(String id) {
        User user = getUserById(id);
        return user.getPosts().stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
    }

    private User getUserById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    private void copyDtoToUser(UserDTO userDTO, User user) {
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
    }
}