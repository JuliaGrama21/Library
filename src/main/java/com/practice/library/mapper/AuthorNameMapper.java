package com.practice.library.mapper;

import com.practice.library.dto.AuthorNameDTO;
import com.practice.library.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorNameMapper implements Mapper<AuthorNameDTO, Author> {

    @Override
    public AuthorNameDTO toDto(Author author) {
        AuthorNameDTO dto = Mapper.MODEL_MAPPER.map(author, AuthorNameDTO.class);
        dto.setFullName(author.getFirstName() + " " + author.getLastName());

        return dto;
    }

    @Override
    public Author fromDto(AuthorNameDTO authorNameDTO) {
        return Mapper.MODEL_MAPPER.map(authorNameDTO, Author.class);
    }
}
