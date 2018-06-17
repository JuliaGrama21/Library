package com.practice.library.dto;

public class BookDTO {

    private Long id;
    private String name;
    private String authorName;
    private String genre;
    private String year;

    public BookDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String  getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
