package com.bookManagement.dto;

import com.bookManagement.enums.Genre;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class SearchDto {

    public String author;
    public Genre genre;
    public Boolean availability;
}
