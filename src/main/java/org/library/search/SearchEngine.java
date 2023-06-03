package org.library.search;

import org.library.author.Author;
import org.library.book.Book;
import org.library.book.Genre;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SearchEngine {
    Optional<List<Book>> findBooksByTitle(String title);
    Optional<List<Book>> findBooksByGenre(Set<Genre> genre);
    Optional<List<Book>> findBooksByTags(Set<String> tags);
    Optional<List<Book>> findBooksByAuthorFirstName(String firstName);
    Optional<List<Book>> findBooksByAuthorLastName(String lastName);
}
