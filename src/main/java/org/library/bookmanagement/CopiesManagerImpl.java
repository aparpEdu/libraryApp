package org.library.bookmanagement;

import org.library.book.Book;
import org.library.checkout.LoanedBooks;

public class CopiesManagerImpl implements CopiesManager {

    @Override
    public int getNumberOfAvailableCopies(Book book) {
        if(StackManager.findPaperBookByIsbn(book.getIsbn()).isPresent()){
            return (int) StackedBooks.getInstance().getStackOfBooks().stream().filter(paperBook -> paperBook.getTitle().equals(book.getTitle())).count();
        }
        return 0;
    }

    @Override
    public int getNumberOfTotalCopies(Book book) {
        int numberOfLoanedCopies = (int) LoanedBooks.getInstance().getBorrowedBooksByUsers().keySet()
                .stream()
                .filter(book1 -> book1.getBook().getTitle().equals(book.getTitle()))
                .count();
        return numberOfLoanedCopies + getNumberOfAvailableCopies(book);
    }
}
