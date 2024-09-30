package com.learning.postgresapp.dao;

import com.learning.postgresapp.domain.Book;

import java.util.Optional;

public interface BookDao {
    public void create(Book book);

    public Optional<Book> findOne(String isbn);
}
