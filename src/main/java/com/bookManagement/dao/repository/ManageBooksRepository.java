package com.bookManagement.dao.repository;

import com.bookManagement.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ManageBooksRepository extends JpaRepository<Book, Integer> {


    @Transactional
    @Modifying
    @Query(value = "UPDATE book SET title = ?1,availability = ?2 WHERE id = ?3", nativeQuery = true)
    void updateTitleAndAvailability(String title, Boolean availability, Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE book SET availability = ?1 WHERE id = ?2", nativeQuery = true)
    void updateAvailability(Boolean availability, Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE book SET title = ?1 WHERE id = ?2", nativeQuery = true)
    void updateTitle(String title, Integer id);

    @Query(value = "SELECT * FROM book b WHERE b.id = ?1", nativeQuery = true)
    Book getBookById(Integer id);
}
