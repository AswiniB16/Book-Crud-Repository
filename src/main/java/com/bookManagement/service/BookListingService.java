package com.bookManagement.service;

import com.bookManagement.dao.entity.Book;
import com.bookManagement.enums.Genre;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface BookListingService {
    List<Book> getBooks(Genre genre, String author, Boolean availability);
    ResponseEntity<Object> getBookById(Integer id);
}
