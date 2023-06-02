package org.library.bookmanagement;

import org.library.book.Book;

public class CopiesManagerImpl implements CopiesManager {

    @Override
    public int getNumberOfAvailableCopies(Book book) {
        if(StackManager.findPaperBookByIsbn(book.getIsbn()).isPresent()){
            return (int) StackedBooks.getInstance().getStackOfBooks().stream().filter(paperBook -> paperBook.equals(book)).count();
        }
        return 0;
    }

    @Override
    public int getNumberOfTotalCopies(Book book) {
        return 0;
    }
}
