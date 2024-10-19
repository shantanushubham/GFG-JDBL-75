package com.geeksforgeeks.library.elib.controller;

import com.geeksforgeeks.library.elib.entity.Book;
import com.geeksforgeeks.library.elib.service.BookService;
import com.geeksforgeeks.library.elib.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final RedisService redisService;

    @Autowired
    public BookController(BookService bookService, RedisService redisService) {
        this.bookService = bookService;
        this.redisService = redisService;
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = this.bookService.addBook ( book );
        return new ResponseEntity<> ( savedBook, HttpStatus.CREATED );
    }

    @GetMapping("/list")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = this.bookService.getAllBooks ();
        this.redisService.addToCache("list", bookList);
        List<Book> testList = (List<Book>) this.redisService.getCacheData("list");
        return new ResponseEntity<> ( bookList, HttpStatus.OK );
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable UUID bookId) {
        Book book = this.bookService.getBookById ( bookId );
        return new ResponseEntity<> ( book, HttpStatus.OK );
    }

    // www.xyz.com/book/{bookId} -- Path Parameter
    // www.xyz.com/book?bookId=1234 -- Query/Request Parameter

}
