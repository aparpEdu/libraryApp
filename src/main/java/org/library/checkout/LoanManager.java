package org.library.checkout;

import org.library.book.Book;
import org.library.bookmanagement.StackManager;
import org.library.bookmanagement.StackedBooks;
import org.library.user.User;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class LoanManager {
   public static void addLoanedBookToSystem(User user, Book book, LocalDate returnDate){
       Optional<LoanedBook> loanedBook = LoanHelper.getBookForLoaning(book,returnDate);
       if(loanedBook.isPresent()){
           LoanedBook loanedBookToAdd = loanedBook.get();
           LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBookToAdd, user.getUsername());
           StackManager.removeBook(book);
           System.out.println("Loaned Book successfully added to System");
       }else{
           System.out.println("Failed to add Loaned Book");
       }
   }
   public static void returnLoanedBook(LoanedBook book){
       StackedBooks.getInstance().getStackOfBooks().add(book.getBook());
       LoanedBooks.getInstance().getBorrowedBooksByUsers().remove(book);
   }
   public static boolean doesUserHaveMaxPostponedBook(User user){
       String userInQuestion = user.getUsername();
       for (Map.Entry<LoanedBook, String> entry : LoanedBooks.getInstance().getBorrowedBooksByUsers().entrySet()) {
           LoanedBook loanedBook = entry.getKey();
           String clientName = entry.getValue();
           if (clientName.equals(userInQuestion) && loanedBook.getDaysDelayed() == 14) {
               return true;
           }
       }
       return false;
   }
}
