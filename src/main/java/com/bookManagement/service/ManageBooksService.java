package com.bookManagement.service;


import com.bookManagement.dto.BookDto;
import com.bookManagement.dto.UpdateBook;
import org.springframework.http.ResponseEntity;

public interface ManageBooksService {
    ResponseEntity<String> save(BookDto book);
    ResponseEntity<String> deleteBookById(Integer id);
    ResponseEntity<String> updateBookInfo(Integer id, UpdateBook updateBook);
}
