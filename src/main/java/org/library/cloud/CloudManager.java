package org.library.cloud;

import org.library.book.ElectronicBook;
import org.library.exception.MissingBookDataException;

import java.util.Optional;

public class CloudManager {

    public static void addElectronicBook(ElectronicBook book){
        if(CloudHelper.bookDataPresent(book)){
            CloudBooks.getInstance().getBooksInCloud().add(book);
        }
    }
    public static Optional<ElectronicBook> findElectronicBookByIsbn(String isbn){
        try {
            return CloudBooks.getInstance().getBooksInCloud().stream().filter(book -> isbn.equals(book.getIsbn())).findFirst();
        }catch (NullPointerException exception){
            throw new MissingBookDataException("No isbn is given for the ebook");
        }
    }
}
