package com.practice.library.mapper;

import com.practice.library.dto.BookDTO;
import com.practice.library.model.Author;
import com.practice.library.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements Mapper<BookDTO, Book>{

    @Override
    public BookDTO toDto(Book book) {
        BookDTO dto = Mapper.MODEL_MAPPER.map(book, BookDTO.class);

        Author author = book.getAuthor();
        dto.setAuthorName(author.getFirstName() + " " + author.getLastName());

        return dto;
    }

    @Override
    public Book fromDto(BookDTO bookDTO) {
        Book book = Mapper.MODEL_MAPPER.map(bookDTO, Book.class);
        book.setPublicationYear(bookDTO.getYear());
        return book;
    }

}

