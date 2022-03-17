package com.devsuperior.dsposts.services;

import java.util.Optional;

import com.devsuperior.dsposts.dto.PostDTO;
import com.devsuperior.dsposts.entities.Post;
import com.devsuperior.dsposts.repositories.PostRepository;
import com.devsuperior.dsposts.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public PostDTO findById(String id) {
        Post post = getPostById(id);
        return new PostDTO(post);
    }

    private Post getPostById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ResourceNotFoundException("Post not found"));
    }
}