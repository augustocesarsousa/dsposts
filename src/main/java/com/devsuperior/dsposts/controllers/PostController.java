package com.devsuperior.dsposts.controllers;

import java.util.List;

import com.devsuperior.dsposts.dto.PostDTO;
import com.devsuperior.dsposts.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        PostDTO postDTO = service.findById(id);
        return ResponseEntity.ok(postDTO);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        List<PostDTO> postsDTO = service.findByTitle(text);
        return ResponseEntity.ok(postsDTO);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<PostDTO>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "start", defaultValue = "") String start,
            @RequestParam(value = "end", defaultValue = "") String end) {
        List<PostDTO> postsDTO = service.fullSearch(text, start, end);
        return ResponseEntity.ok(postsDTO);
    }
}