package com.bookManagement.service.impl;

import com.bookManagement.dao.entity.Book;
import com.bookManagement.dao.repository.ManageBooksRepository;
import com.bookManagement.dto.SearchDto;
import com.bookManagement.enums.Genre;
import com.bookManagement.service.BookListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class BookListingServiceServiceImpl implements BookListingService {

    @Autowired
    ManageBooksRepository manageBooksRepository;


    @Override
    public ResponseEntity<Object> getBookById(Integer id) {
        var book= manageBooksRepository.getBookById(id);
        if (book != null)
            return ResponseEntity.ok(book);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
    }


    @Override
    public List<Book> getBooks(Genre genre, String author, Boolean availability) {
        var books = manageBooksRepository.findAll();
        var searchCriteria = SearchDto.builder().author(author).genre(genre).availability(availability).build();
        return searchBooks(books, searchCriteria);
    }

    public List<Book> searchBooks(List<Book> books, SearchDto criteria) {
        return books.stream()
                .filter(book -> matches(book, criteria))
                .collect(Collectors.toList());
    }

    private boolean matches(Book book, SearchDto criteria) {
        boolean matches = true;

        if (criteria.getAuthor() != null)
            matches = matches && matchesRegex(book.getAuthor(), criteria.getAuthor());

        if (criteria.getGenre() != null)
            matches = matches && matchesRegex(book.getGenre().name(), criteria.getGenre().name());

        if (criteria.getAvailability() != null)
            matches = matches && book.getAvailability().equals(criteria.getAvailability());


        return matches;
    }

    private boolean matchesRegex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(input).find(); // Use find() to check for partial matches
    }
}