package com.practice.library.controller;

import com.practice.library.model.Author;
import com.practice.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping("/")
    public Iterable<Author> index() {
        return authorRepository.findAll();
    }

    @RequestMapping("/all")
    public String all() {
        return "Another message!";
    }
}
