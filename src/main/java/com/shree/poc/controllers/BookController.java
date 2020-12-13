package com.shree.poc.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.shree.poc.entities.Book;
import com.shree.poc.exceptions.BookIdMismatchException;
import com.shree.poc.exceptions.BookNotFoundException;
import com.shree.poc.repositories.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {

	private static final Logger LOG = LoggerFactory.getLogger(BookController.class);
	
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable findAll() {
    	LOG.info("findAll() called");
        return bookRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List findByTitle(@PathVariable String bookTitle) {
    	LOG.info("findByTitle() called {}", bookTitle);
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
    	LOG.info("findOne() called ID: {}", id);
        return bookRepository.findById(id)
          .orElseThrow(BookNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
    	LOG.info("Create new book called: {}", book);
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	LOG.info("Delete book called with ID: {}", id);
        bookRepository.findById(id)
          .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
    	LOG.info("Update book called with book: {} and id: {}", book, id);
        if (book.getId() != id) {
          throw new BookIdMismatchException();
        }
        bookRepository.findById(id)
          .orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }
    
}