package com.learning.postgresapp;

import com.learning.postgresapp.domain.Author;
import com.learning.postgresapp.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){}

    public static Author getAuthorObject(){
        return Author.builder()
                .id(1L)
                .name("Sultan")
                .age(24)
                .build();
    }

    public static Book getBookObject() {
        return Book.builder()
                .isbn("932-323-213-1")
                .title("My Life")
                .authorId(1L)
                .build();
    }
}
