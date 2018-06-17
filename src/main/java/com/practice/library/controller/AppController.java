package com.practice.library.controller;

import com.practice.library.dto.AuthorDTO;
import com.practice.library.dto.BookDTO;
import com.practice.library.mapper.Mapper;
import com.practice.library.model.Author;
import com.practice.library.model.Book;
import com.practice.library.repository.AuthorRepository;
import com.practice.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private Mapper<AuthorDTO, Author> authorMapper;

    @Autowired
    private Mapper<BookDTO, Book> bookMapper;

    @RequestMapping("/getBooks")
    @ResponseBody
    public List<BookDTO> getBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDTO> booksDTO = new ArrayList<>();

        books.forEach(book -> {
            BookDTO bookDTO = bookMapper.toDto(book);
            booksDTO.add(bookDTO);
        });
        return booksDTO;
    }

    @RequestMapping("/getAuthors")
    @ResponseBody
    public List<AuthorDTO> getAuthors() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDTO> authorsDTO = new ArrayList<>();

        authors.forEach(author -> {
            AuthorDTO authorDTO = authorMapper.toDto(author);
            authorsDTO.add(authorDTO);
        });
        return authorsDTO;
    }

    @RequestMapping("/updateAuthor")
    @ResponseBody
    public AuthorDTO updateAuthor(@RequestBody AuthorDTO authorDTO) {
        Author authorFromDto = authorMapper.fromDto(authorDTO);
        return authorMapper.toDto(authorRepository.save(authorFromDto));
    }

    @RequestMapping("/deleteAuthor")
    @ResponseBody
    public String updateAuthor(@RequestBody Long authorId) {
        authorRepository.deleteById(authorId);

        return "success";
    }

    @RequestMapping("/authors")
    public String authors() {
        return "authors.html";
    }

    @RequestMapping("/books")
    public String books() {
        return "books.html";
    }
}
