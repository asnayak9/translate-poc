package com.shree.poc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shree.poc.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByTitle(String title);
}
