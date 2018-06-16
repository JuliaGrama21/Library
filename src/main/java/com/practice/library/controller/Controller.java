package com.practice.library.controller;

import com.practice.library.dto.AuthorDTO;
import com.practice.library.dto.BookDTO;
import com.practice.library.mapper.Mapper;
import com.practice.library.model.Author;
import com.practice.library.model.Book;
import com.practice.library.repository.AuthorRepository;
import com.practice.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private Mapper<AuthorDTO, Author> authorMapper;

    @Autowired
    private Mapper<BookDTO, Book> bookMapper;

    @RequestMapping("/books")
    public List<BookDTO> getBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDTO> booksDTO = new ArrayList<>();

        books.forEach(book -> {
            BookDTO bookDTO = bookMapper.toDto(book);
            booksDTO.add(bookDTO);
        });
        return booksDTO;
    }

    @RequestMapping("/authors")
    public List<AuthorDTO> getAuthors() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDTO> authorsDTO = new ArrayList<>();

        authors.forEach(author -> {
            AuthorDTO authorDTO = authorMapper.toDto(author);
            authorsDTO.add(authorDTO);
        });
        return authorsDTO;
    }
}
