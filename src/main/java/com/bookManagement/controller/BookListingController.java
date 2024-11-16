package com.bookManagement.controller;

import com.bookManagement.dao.entity.Book;
import com.bookManagement.enums.Genre;
import com.bookManagement.service.BookListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class BookListingController {

    @Autowired
    BookListingService bookListingService;

    @GetMapping(value = "/books")
    public List<Book> getBooks(@RequestParam(required = false) Genre genre , @RequestParam(required = false) String author,
                               @RequestParam(required = false) Boolean availability) {
        return bookListingService.getBooks(genre,author,availability);
    }
    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable Integer id) {
        return bookListingService.getBookById(id);
    }

}
