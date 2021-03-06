package com.practice.library.repository;

import com.practice.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author getAuthorByFirstNameAndLastName(String firstName, String lastName);

}
