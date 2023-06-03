package org.library.cloud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.author.Author;
import org.library.book.ElectronicBook;
import org.library.book.Genre;
import org.library.country.Country;
import org.library.system.UserBookHistory;
import org.library.user.User;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public  class ElectronicReaderTest {

    @BeforeEach
    void setUp() {
        UserBookHistory.getInstance().getReadElectronicBooksByUser().clear();
    }

    @Test
    void shouldAddReadEBookToUserHistoryAfterReadingWhenCriteriaMet() {
        User reader = new User();
        reader.setLoggedIn(true);
        reader.setUsername("Flapjack");
        ElectronicBook readElectronicBook = new ElectronicBook();
        readElectronicBook.setTitle("Marshal D. Teach");
        readElectronicBook.setIsbn("3,996,000,000B");
        readElectronicBook.setReadingLink("www.itsThem.com");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        readElectronicBook.setAuthors(Set.of(author));
        readElectronicBook.setGenres(Set.of(Genre.ROMANCE));
        int numberOfEBooksBeforeReading = UserBookHistory.getInstance().getReadElectronicBooksByUser().size();
        ElectronicReader.readElectronicBook(reader, readElectronicBook);
        int numberOfEBooksAfterReading = UserBookHistory.getInstance().getReadElectronicBooksByUser().size();
        assertTrue(numberOfEBooksAfterReading > numberOfEBooksBeforeReading);
    }

    @Test
    void shouldNotAddReadEBookToUserHistoryWhenNotLoggedIn() {
        User reader = new User();
        reader.setLoggedIn(false);
        reader.setUsername("Flapjack");
        ElectronicBook readElectronicBook = new ElectronicBook();
        readElectronicBook.setTitle("Marshal D. Teach");
        readElectronicBook.setIsbn("3,996,000,000B");
        readElectronicBook.setReadingLink("www.itsThem.com");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        readElectronicBook.setAuthors(Set.of(author));
        readElectronicBook.setGenres(Set.of(Genre.ROMANCE));
        int numberOfEBooksBeforeReading = UserBookHistory.getInstance().getReadElectronicBooksByUser().size();
        ElectronicReader.readElectronicBook(reader, readElectronicBook);
        int numberOfEBooksAfterReading = UserBookHistory.getInstance().getReadElectronicBooksByUser().size();
        assertFalse(numberOfEBooksAfterReading > numberOfEBooksBeforeReading);
    }

    @Test
    void shouldNotAddReadEBookToUserHistoryWhenMissingBookData() {
        User reader = new User();
        reader.setLoggedIn(true);
        reader.setUsername("Flapjack");
        ElectronicBook readElectronicBook = new ElectronicBook();
        readElectronicBook.setIsbn("3,996,000,000B");
        readElectronicBook.setReadingLink("www.itsThem.com");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        readElectronicBook.setAuthors(Set.of(author));
        readElectronicBook.setGenres(Set.of(Genre.ROMANCE));
        int numberOfEBooksBeforeReading = UserBookHistory.getInstance().getReadElectronicBooksByUser().size();
        ElectronicReader.readElectronicBook(reader, readElectronicBook);
        int numberOfEBooksAfterReading = UserBookHistory.getInstance().getReadElectronicBooksByUser().size();
        assertFalse(numberOfEBooksAfterReading > numberOfEBooksBeforeReading);
    }

}