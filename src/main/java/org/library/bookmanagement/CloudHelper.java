package org.library.bookmanagement;

import org.library.author.Author;
import org.library.book.Book;
import org.library.book.ElectronicBook;
import org.library.book.Genre;

import java.util.Optional;
import java.util.Set;

public class CloudHelper implements BookManager {
    @Override
    public boolean bookDataPresent(Book book){
        Optional<String> bookTitle = Optional.ofNullable(book.getTitle());
        Optional<Set<Author>> bookAuthors = Optional.ofNullable(book.getAuthors());
        Optional<Set<Genre>> bookGenres = Optional.ofNullable(book.getGenres());
        Optional<String> bookIsbn = Optional.ofNullable((book.getIsbn()));
        if(!readLinkAvailable((ElectronicBook) book)){
            return false;
        }
        if(bookTitle.isPresent() && bookAuthors.isPresent() && bookGenres.isPresent() && bookIsbn.isPresent()){
            return  true;
        }
        System.out.println("Book has missing data!");
        return false;
    }
    public boolean readLinkAvailable(ElectronicBook book){
        if(book.getReadingLink() != null){
            return true;
        }
        System.out.println("E-Book is missing a reading link!");
        return false;
    }
}
