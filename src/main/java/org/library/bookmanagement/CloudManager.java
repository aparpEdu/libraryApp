package org.library.bookmanagement;

import org.library.book.Book;
import org.library.book.ElectronicBook;

import java.util.Optional;

public class CloudManager {

    public static void addElectronicBook(ElectronicBook book){
        if(CloudHelper.bookDataPresent(book)){
            CloudBooks.getInstance().getBooksInCloud().add(book);
        }
    }
    public static Optional<ElectronicBook> findElectronicBookByIsbn(String isbn){
        return CloudBooks.getInstance().getBooksInCloud().stream().filter(book -> isbn.equals(book.getIsbn())).findFirst();
    }
}
