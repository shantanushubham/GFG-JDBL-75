package com.geeksforgeeks.library.elib.service;

import com.geeksforgeeks.library.elib.ELibraryApplication;
import com.geeksforgeeks.library.elib.entity.Book;
import com.geeksforgeeks.library.elib.enums.Category;
import com.geeksforgeeks.library.elib.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

@SpringBootTest(classes = ELibraryApplication.class)
public class BookServiceTest {

    private final BookService bookService;

    @Autowired
    public BookServiceTest(BookService bookService) {
        this.bookService = bookService;
    }

    @MockBean
    private BookRepository bookRepository;

    static Book book = Book.builder()
            .id(UUID.randomUUID())
            .author("TestAuthor")
            .category(Category.FICTION)
            .description("TestDesc")
            .isbn("TestISBN")
            .name("TestName")
            .price(400D).build();

    @Test
    void getAllBooks_whenThereAreAListBooks_shouldReturnAListOfBooks() {
        List<Book> bookList = Arrays.asList(book, book.withPrice(500D), book.withPrice(600D));

        Mockito.when(this.bookRepository.findAll()).thenReturn(bookList);
        List<Book> fetchedBookList = this.bookService.getAllBooks();

        Assertions.assertEquals(bookList.size(), fetchedBookList.size());
    }

    @Test
    void getAllBooks_whenThereAreNoBooks_shouldReturnAEmptyList() {
        Mockito.when(this.bookRepository.findAll()).thenReturn(Collections.emptyList());
        List<Book> fetchedBookList = this.bookService.getAllBooks();

        Assertions.assertEquals(0, fetchedBookList.size());
    }

    @Test
    void getBookById_whenTheBookExists_shouldReturnBook() {
        Mockito.when(this.bookRepository.findById(book.getId())).thenReturn(Optional.of(book));

        Book book1 = this.bookService.getBookById(book.getId());
        Assertions.assertEquals(book, book1);
    }

    @Test
    void getBookById_whenTheBookDoesNotExist_shouldReturnNull() {
        UUID invalidId = UUID.randomUUID();
        Mockito.when(this.bookRepository.findById(invalidId)).thenReturn(Optional.empty());

        Book book1 = this.bookService.getBookById(invalidId);
        Assertions.assertNull(book1);
    }

    @Test
    void addBook_whenBookIsPassed_shouldReturnAddedBook() {
        Mockito.when(this.bookRepository.save(book)).thenReturn(book);

        Book book1 = this.bookService.addBook(book);
        Assertions.assertEquals(book, book1);
    }
}
