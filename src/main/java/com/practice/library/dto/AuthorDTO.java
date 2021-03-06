package com.practice.library.dto;

import java.util.List;

public class AuthorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private List<String> booksName;

    public AuthorDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getBooksName() {
        return booksName;
    }

    public void setBooksName(List<String> booksName) {
        this.booksName = booksName;
    }
}
