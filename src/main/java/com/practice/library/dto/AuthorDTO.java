package com.practice.library.dto;

import java.util.List;

public class AuthorDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private List<String> booksName;

    public AuthorDTO(){}

    public AuthorDTO(Integer id, String firstName, String lastName, List<String> booksName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.booksName = booksName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
