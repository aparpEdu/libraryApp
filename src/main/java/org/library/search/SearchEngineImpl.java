package org.library.search;

import org.library.book.Book;
import org.library.book.Genre;
import org.library.bookmanagement.StackedBooks;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchEngineImpl implements SearchEngine{
    private final StackedBooks stackedBooks;

    public SearchEngineImpl() {
       stackedBooks = StackedBooks.getInstance();
    }

    @Override
    public Optional<List<Book>> findBooksByTitle(String title) {
        return Optional.of(stackedBooks.getStackOfBooks().stream().filter(book -> title.equals(book.getTitle())).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<Book>> findBooksByGenre(Set<Genre> genre) {
        return Optional.of(stackedBooks.getStackOfBooks().stream()
                .filter(book -> genre.equals(book.getGenres()))
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<Book>> findBooksByTags(Set<String> tags) {
        return Optional.of(stackedBooks.getStackOfBooks().stream().filter(book ->tags.equals(book.getTags())).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<Book>> findBooksByAuthorFirstName(String firstName) {
        return Optional.of(stackedBooks.getStackOfBooks().stream()
                .filter(book -> book.getAuthors().stream()
                        .anyMatch(author -> firstName.equals(author.getFirstName())))
                .collect(Collectors.toList()));
    }
    @Override
    public Optional<List<Book>> findBooksByAuthorLastName(String lastName) {
        return Optional.of(stackedBooks.getStackOfBooks().stream()
                .filter(book -> book.getAuthors().stream()
                        .anyMatch(author -> lastName.equals(author.getLastName())))
                .collect(Collectors.toList()));
    }
}
