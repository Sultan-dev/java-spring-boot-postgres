package com.learning.postgresapp.dao.impl;

import com.learning.postgresapp.TestDataUtil;
import com.learning.postgresapp.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {

    @InjectMocks
    private BookDaoImpl underTest;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testThatCreateBookGeneratesCorrectSql(){
        Book book = TestDataUtil.getBookObject();

        underTest.create(book);

        verify(jdbcTemplate).update(eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),eq("932-323-213-1"), eq("My Life"), eq(1L));
    }

    @Test
    public void testThatFindOneBookGeneratesCorrectSql(){
        underTest.findOne("932-323-213-1");

        verify(jdbcTemplate).query(eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1")
                ,ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(BookDaoImpl.BookRowMapper.class)
                , eq("932-323-213-1"));
    }
}
