package com.learning.postgresapp;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class PostgresappApplication{
	public static void main(String[] args) {
		SpringApplication.run(PostgresappApplication.class, args);
	}
}
