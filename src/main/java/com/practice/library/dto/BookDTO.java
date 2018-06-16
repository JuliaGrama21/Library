package com.practice.library.dto;

public class BookDTO {

    private Integer id;
    private String name;
    private String authorName;
    private String genre;
    private String year;

    public BookDTO() {}

    public BookDTO(Integer id, String name, String authorName, String genre, String year) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.genre = genre;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
