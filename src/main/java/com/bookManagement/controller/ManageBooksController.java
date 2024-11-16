package com.bookManagement.controller;

import com.bookManagement.dto.BookDto;
import com.bookManagement.dto.UpdateBook;
import com.bookManagement.service.ManageBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManageBooksController {

    @Autowired
    ManageBooksService manageBooksService;

    @PostMapping(value = "/books")
    public ResponseEntity<String> saveBooks(@RequestBody BookDto book) {
        return manageBooksService.save(book);
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Integer id) {
        return manageBooksService.deleteBookById(id);
    }

    @PatchMapping(value = "/books/{id}")
    public ResponseEntity<String> updateBookInfo(@PathVariable Integer id, @RequestBody UpdateBook updateBook) {
        return manageBooksService.updateBookInfo(id, updateBook);
    }
}