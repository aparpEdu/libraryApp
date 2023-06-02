package org.library.bookmanagement;

import lombok.Getter;
import lombok.Setter;
import org.library.book.Book;

import java.util.ArrayList;
import java.util.List;

public class StackedBooks {
    @Getter
    @Setter
    private List<Book> stackOfBooks = new ArrayList<>();
    private static StackedBooks instance = null;
    private StackedBooks(){}
    public static StackedBooks getInstance(){
        if(instance == null){
            instance = new StackedBooks();
        }
        return instance;
    }
}
