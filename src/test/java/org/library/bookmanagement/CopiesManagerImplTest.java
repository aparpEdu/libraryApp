package org.library.bookmanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.book.Book;
import org.library.checkout.LoanedBook;
import org.library.checkout.LoanedBooks;
import org.library.user.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CopiesManagerImplTest {

    @BeforeEach
    void setUp() {
        StackedBooks.getInstance().getStackOfBooks().clear();
    }

    @Test
    void shouldReturnNumberOfAvailableCopiesWhenBookPresent() {
        CopiesManagerImpl copiesManager = new CopiesManagerImpl();
        Book firstBook = new Book();
        firstBook.setTitle("Top Gear 101");
        firstBook.setIsbn("123");
        Book secondBook = new Book();
        secondBook.setTitle("Top Gear 101");
        secondBook.setIsbn("123");
        StackedBooks.getInstance().getStackOfBooks().add(firstBook); //adding first copy
        StackedBooks.getInstance().getStackOfBooks().add(secondBook); //adding second copy
        int expectedNumberOfAvailableCopies = 2;
        int numberOfAvailableCopies = copiesManager.getNumberOfAvailableCopies(firstBook);
        assertEquals(expectedNumberOfAvailableCopies,numberOfAvailableCopies);
    }

    @Test
    void shouldReturnTotalNumberOfCopies(){
        CopiesManagerImpl copiesManager = new CopiesManagerImpl();
        Book firstBook = new Book();
        firstBook.setTitle("Top Gear 101");
        firstBook.setIsbn("123");
        Book secondBook = new Book();
        secondBook.setTitle("Top Gear 101");
        secondBook.setIsbn("123");
        LoanedBook loanedBook = new LoanedBook();
        loanedBook.setBook(firstBook);
        User user = new User();
        user.setUsername("BlackPink");
        LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook,user.getUsername()); //adding a loaned book
        StackedBooks.getInstance().getStackOfBooks().add(firstBook); //adding first copy
        StackedBooks.getInstance().getStackOfBooks().add(secondBook); //adding second copy
        int expectedNumberOfTotalCopies = 3;
        int numberOfTotalCopies = copiesManager.getNumberOfTotalCopies(firstBook);
        assertEquals(expectedNumberOfTotalCopies,numberOfTotalCopies);
    }
}