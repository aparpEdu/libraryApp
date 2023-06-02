package org.library.bookmanagement;

import org.library.book.ElectronicBook;

public class CloudManager {

    public void addElectronicBook(ElectronicBook book){
        if(CloudHelper.bookDataPresent(book)){
            CloudBooks.getInstance().getBooksInCloud().add(book);
        }
    }
}
