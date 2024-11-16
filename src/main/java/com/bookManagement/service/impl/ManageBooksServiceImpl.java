package com.bookManagement.service.impl;

import com.bookManagement.dao.entity.Book;
import com.bookManagement.dao.repository.ManageBooksRepository;
import com.bookManagement.dto.BookDto;
import com.bookManagement.dto.UpdateBook;
import com.bookManagement.service.ManageBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManageBooksServiceImpl implements ManageBooksService {

    @Autowired
    ManageBooksRepository manageBooksRepository;

    @Override
    public ResponseEntity<String> save(BookDto book) {
        List<com.bookManagement.dao.entity.Book> bookEntities = new ArrayList<>();

        var bookEntity = com.bookManagement.dao.entity.Book.builder()
                .userId(book.userId).title(book.title).author(book.author)
                .genre(book.genre).publishedDate(book.publishedDate).availability(book.availability)
                .build();
        bookEntities.add(bookEntity);
        var savedBooks = manageBooksRepository.saveAll(bookEntities);
        if (!savedBooks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Book added successfully.");
        } else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation errors or missing fields.");
    }

    @Override
    public ResponseEntity<String> deleteBookById(Integer id) {
        var book = manageBooksRepository.getBookById(id);
        if (book != null) {
            manageBooksRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Book deleted.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");

    }

    @Override
    public ResponseEntity<String> updateBookInfo(Integer id, UpdateBook updateBook) {
        var book = manageBooksRepository.getBookById(id);
        if (book != null) {
            if (updateBook.getAvailability() != null && updateBook.getTitle() != null) {
                manageBooksRepository.updateTitleAndAvailability(updateBook.getTitle(), updateBook.getAvailability(), id);
            } else if (updateBook.getAvailability() != null) {
                manageBooksRepository.updateAvailability(updateBook.getAvailability(), id);
            } else if (updateBook.getTitle() != null) {
                manageBooksRepository.updateTitle(updateBook.getTitle(), id);
            }
            return ResponseEntity.ok("Book updated successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");   }
}
