package org.library.bookmanagement;

import org.library.author.Author;
import org.library.book.Book;
import org.library.book.Genre;

import java.util.Optional;
import java.util.Set;

public class StackHelper implements BookManager {
    @Override
    public boolean bookDataPresent(Book book) {
        Optional<String> bookTitle = Optional.ofNullable(book.getTitle());
        Optional<Set<Author>> bookAuthors = Optional.ofNullable(book.getAuthors());
        Optional<Set<Genre>> bookGenres = Optional.ofNullable(book.getGenres());
        Optional<String> bookIsbn = Optional.ofNullable((book.getIsbn()));
        return false;
    }
}
