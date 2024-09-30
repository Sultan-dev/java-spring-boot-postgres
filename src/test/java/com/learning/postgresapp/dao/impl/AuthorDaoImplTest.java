package com.learning.postgresapp.dao.impl;

import com.learning.postgresapp.TestDataUtil;
import com.learning.postgresapp.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.tree.RowMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTest {

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql(){
        Author author = TestDataUtil.getAuthorObject();

        underTest.create(author);

        verify(jdbcTemplate).update(eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L),
                eq("Sultan"),
                eq(24));
    }

    @Test
    public void testThatFindOneGenerateTheCorrectSql(){
        underTest.findOne(1L);

        verify(jdbcTemplate).query(eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(AuthorDaoImpl.AuthorRowMapper.class),
                eq(1L));
    }
}
