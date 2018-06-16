package com.practice.library.mapper;

import com.practice.library.dto.AuthorDTO;
import com.practice.library.model.Author;
import com.practice.library.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorMapper implements Mapper<AuthorDTO, Author>{

    @Override
    public AuthorDTO toDto(Author author) {
        AuthorDTO dto = Mapper.MODEL_MAPPER.map(author, AuthorDTO.class);

        List<String> booksName = author.getBooks()
                .stream()
                .map(Book::getName)
                .collect(Collectors.toList());

        dto.setBooksName(booksName);

        return dto;
    }

    @Override
    public Author fromDto(AuthorDTO authorDTO) {
        return Mapper.MODEL_MAPPER.map(authorDTO, Author.class);
    }

}
