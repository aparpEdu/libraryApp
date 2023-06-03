package org.library.search;

import org.library.book.Book;
import org.library.book.Genre;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class SearchBook {
    private static final SearchEngineImpl searchEngine = new SearchEngineImpl();
    public static Optional<List<Book>> searchBooksByTitle(String title){
       return searchEngine.findBooksByTitle(title);
    }

    public static Optional<List<Book>> searchBooksByGenre(Set<Genre> genres){
        return searchEngine.findBooksByGenre(genres);
    }

    public static Optional<List<Book>> searchBooksByTags(Set<String> tags){
        return searchEngine.findBooksByTags(tags);
    }

    public static Optional<List<Book>> searchBooksByAuthorFirstName(String firstName){
        return searchEngine.findBooksByAuthorFirstName(firstName);
    }
    public static Optional<List<Book>> searchBooksByAuthorLastName(String lastName){
        return searchEngine.findBooksByAuthorFirstName(lastName);
    }
}
