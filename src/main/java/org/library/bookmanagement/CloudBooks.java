package org.library.bookmanagement;

import lombok.Getter;
import lombok.Setter;
import org.library.book.Book;

import java.util.HashSet;
import java.util.Set;

public class CloudBooks {
    @Getter
    @Setter
    private Set<Book> booksInCloud = new HashSet<>();
    private static CloudBooks instance = null;
    private CloudBooks(){}
    public static CloudBooks getInstance(){
        if(instance == null){
            instance = new CloudBooks();
        }
        return instance;
    }
}
