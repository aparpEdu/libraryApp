package org.library.checkout;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.library.book.Book;
import org.library.user.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanedBooksTest {

    @BeforeEach
    void setUp() {
        LoanedBooks.getInstance().getBorrowedBooksByUsers().clear();
    }

    @Test
    public void shouldBeAbleToMakeOnlyOneInstance() {
        LoanedBooks firstInstance = LoanedBooks.getInstance();
        LoanedBooks secondInstance = LoanedBooks.getInstance();
        User user = new User();
        user.setUsername("HaroldRafaello");
        Book firstBook = new Book();
        firstBook.setTitle("Lord Of The Rings");
        Book secondBook = new Book();
        secondBook.setTitle("Lord Of The Rings 2");
        LoanedBook loanedBook = new LoanedBook();
        loanedBook.setBook(firstBook);
        firstInstance.getBorrowedBooksByUsers().put(loanedBook,user.getUsername());
        assertEquals(firstInstance, secondInstance);
    }
}