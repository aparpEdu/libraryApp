package org.library;


import org.library.book.Book;
import org.library.book.ElectronicBook;
import org.library.bookmanagement.StackManager;
import org.library.bookmanagement.StackedBooks;

public class LibraryApp
{
    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("ff");
        Book book1 = new Book();
        book1.setTitle("ff");
        StackedBooks.getInstance().getStackOfBooks().add(book);
        StackedBooks.getInstance().getStackOfBooks().add(book1);
        System.out.println(StackedBooks.getInstance().getStackOfBooks());
        StackedBooks.getInstance().getStackOfBooks().remove(book);
        System.out.println(StackedBooks.getInstance().getStackOfBooks());
    }
}

