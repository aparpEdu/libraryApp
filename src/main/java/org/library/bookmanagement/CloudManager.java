package org.library.bookmanagement;

import org.library.book.ElectronicBook;

public class CloudManager {

    public void addElectronicBook(ElectronicBook book){
        CloudHelper cloudHelper = new CloudHelper();
        if(cloudHelper.bookDataPresent(book)){
            CloudBooks.getInstance().getBooksInCloud().add(book);
        }
    }
}
