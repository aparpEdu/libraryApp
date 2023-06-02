package org.library.bookmanagement;

import org.library.book.Book;

public interface CopiesManager {
    int getNumberOfAvailableCopies(Book book);
    int getNumberOfTotalCopies(Book book);
}
