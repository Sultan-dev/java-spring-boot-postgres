package com.learning.postgresapp.dao;

import com.learning.postgresapp.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    public void create(Author author);

    public Optional<Author> findOne(long id);
}
