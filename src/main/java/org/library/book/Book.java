package org.library.book;

import lombok.Data;
import org.library.author.Author;

import java.util.Set;

@Data
public class Book {
    private String title;
    private Set<Author> authors;
    private Set<Genre> genres;
    private String summary;
    private String isbn;
    private Set<String> tags;
}
