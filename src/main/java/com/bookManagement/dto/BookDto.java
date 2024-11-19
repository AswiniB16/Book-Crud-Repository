package com.bookManagement.dto;

import com.bookManagement.enums.Genre;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class BookDto {

    private Integer id;
    public String userId;
    public String title;
    public String author;
    public Genre genre;
    public Boolean availability;
    public LocalDate publishedDate;

}
