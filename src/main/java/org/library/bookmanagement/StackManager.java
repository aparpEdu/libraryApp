package org.library.bookmanagement;

import org.library.book.Book;
import org.library.exception.MissingBookDataException;

import java.util.Optional;

public class StackManager {
    public static void addPaperBookToStack(Book book){
        if(BookManager.generalBookDataPresent(book)){
            StackedBooks.getInstance().getStackOfBooks().add(book);
        }
    }

    public static Optional<Book> findPaperBookByIsbn(String isbn){
        try {
            return StackedBooks.getInstance().getStackOfBooks().stream().filter(book -> isbn.equals(book.getIsbn())).findFirst();
        }
        catch (NullPointerException exception){
           throw new MissingBookDataException("Book does not have an isbn!");
        }

    }
    public static void removeBook(Book book){
        if(findPaperBookByIsbn(book.getIsbn()).isPresent()){
            StackedBooks.getInstance().getStackOfBooks().remove(book);
        }
    }
}
