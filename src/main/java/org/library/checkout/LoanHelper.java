package org.library.checkout;

import org.library.book.Book;
import org.library.bookmanagement.BookManager;
import org.library.exception.MissingBookDataException;

import java.time.LocalDate;
import java.util.Optional;

public class LoanHelper {
    public static Optional<LoanedBook> getBookForLoaning(Book book, LocalDate returnDate){
        if(BookManager.generalBookDataPresent(book)){
            LoanedBook bookForLoaning = new LoanedBook();
            bookForLoaning.setBook(book);
            bookForLoaning.setReturnDate(returnDate);
            return Optional.of(bookForLoaning);
        }
        return Optional.empty();
    }
    public static boolean isLoanedBookInSystem(LoanedBook book){
       return LoanedBooks.getInstance().getBorrowedBooksByUsers().containsKey(book);
    }
    public static void adjustReturnDate(LoanedBook loanedBook,int numberOfDays){
        try {
            loanedBook.setReturnDate(loanedBook.getReturnDate().plusDays(numberOfDays));
        }catch (NullPointerException exception){
          throw new MissingBookDataException("No return date specified in book!");
        }
    }
}
