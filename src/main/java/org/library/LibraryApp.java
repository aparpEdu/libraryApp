package org.library;


import org.library.book.Book;
import org.library.book.ElectronicBook;
import org.library.bookmanagement.StackManager;
import org.library.bookmanagement.StackedBooks;
import org.library.checkout.LoanHelper;
import org.library.checkout.LoanManager;
import org.library.checkout.LoanedBook;
import org.library.checkout.LoanedBooks;
import org.library.user.User;

import java.time.LocalDate;
import java.util.Map;

public class LibraryApp
{
    public static void main(String[] args) {
      Book book = new Book();
      book.setIsbn("23");
      Book book2 = new Book();
      book.setIsbn("233");
        LoanedBook loanedBook = new LoanedBook();
        loanedBook.setReturnDate(LocalDate.now());
        loanedBook.setBook(book);
        loanedBook.setDaysDelayed(14);
        LoanedBook loanedBook2 = new LoanedBook();
        loanedBook.setReturnDate(LocalDate.now());
        loanedBook.setBook(book2);
        loanedBook.setDaysDelayed(14);

      User user = new User();
      user.setUsername("rashid");
      LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook,user.getUsername());
      LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook2,user.getUsername());
      System.out.println(LoanManager.doesUserHaveMaxPostponedBook(user));

    }
}

