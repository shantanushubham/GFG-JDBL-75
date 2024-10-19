package com.geeksforgeeks.library.elib.service;

import com.geeksforgeeks.library.elib.entity.Book;
import com.geeksforgeeks.library.elib.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        log.info("Saving a new book");
        Book savedBook = this.bookRepository.save(book);
        log.info("Saved a new book with ID: {}", savedBook.getId());
        return savedBook;
    }

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public Book getBookById(UUID bookId) {
        Optional<Book> bookOptional = this.bookRepository.findById(bookId);
        return bookOptional.orElse(null);
    }

}
