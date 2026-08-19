package com.example.springBoot2.controllers;


import com.example.springBoot2.models.Book;
import com.example.springBoot2.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping("/book")
    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping("/book")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable int id) {
        bookRepository.deleteById(id);
    }
}
