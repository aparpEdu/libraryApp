package org.library.bookmanagement;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.library.book.Book;
import org.library.book.ElectronicBook;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

 public class StackedBooksTest {

    @BeforeEach
    void setUp() {
        StackedBooks.getInstance().getStackOfBooks().clear();
    }

     @Test
     public void shouldBeAbleToMakeOnlyOneInstance() {
         StackedBooks firstInstance = StackedBooks.getInstance();
         StackedBooks secondInstance = StackedBooks.getInstance();
         Book book = new Book();
         book.setSummary("Use the breath wisely");
         book.setTitle("Galactic Football");
         firstInstance.setStackOfBooks(List.of(book)); //changing List in firstInstance
         assertEquals(firstInstance, secondInstance);
     }
}