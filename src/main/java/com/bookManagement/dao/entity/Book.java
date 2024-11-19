package com.bookManagement.dao.entity;

import com.bookManagement.enums.Genre;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "book")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Generated
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String userId;
    public String title;
    public String author;
    @Enumerated(EnumType.STRING)
    public Genre genre;

    public Boolean availability;
    public LocalDate publishedDate;

}
