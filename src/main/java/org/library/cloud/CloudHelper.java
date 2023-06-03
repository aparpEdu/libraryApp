package org.library.cloud;

import org.library.book.Book;
import org.library.book.ElectronicBook;
import org.library.bookmanagement.BookManager;

import static org.library.bookmanagement.BookManager.readLinkAvailable;

public class CloudHelper{

    public static boolean bookDataPresent(Book book){
        return readLinkAvailable((ElectronicBook) book) && BookManager.generalBookDataPresent(book);
    }

}
