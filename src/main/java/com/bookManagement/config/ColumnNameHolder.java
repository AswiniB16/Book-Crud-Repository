package com.bookManagement.config;

import com.bookManagement.dao.entity.Book;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Getter
@Component
@AllArgsConstructor
public class ColumnNameHolder {
    private final Map<String, Function<Book, Object>> columnNameHolder = new HashMap<>();

    @PostConstruct
    public void addColumnNames() {
        columnNameHolder.put("author", Book::getAuthor);
        columnNameHolder.put("genre", Book::getGenre);
    }
}
