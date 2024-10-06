package com.geeksforgeeks.library.elib.repository;

import com.geeksforgeeks.library.elib.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
}
