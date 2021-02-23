package com.domingosm.bookcity.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public Book getBook(Long bookId) {
        boolean exists = repository.existsById(bookId);
        if (!exists)
            throw new NoSuchElementException("record with id " + bookId + " not found");

        Optional<Book> book = repository.findById(bookId);
        return book.get();
    }

    public void addBook(Book book) {
        List<Book> bookList = repository.findAll();
        bookList.forEach(dbBook -> {
            if (dbBook.getBookIsbn().equals(book.getBookIsbn())
                    && dbBook.getBookTitle().equals(book.getBookTitle()))
                throw new ConcurrentModificationException("already exists");
        });
        repository.save(book);
    }

    public void updateQuantity(Long bookId) {
        boolean exists = repository.existsById(bookId);
        if (!exists)
            throw new NoSuchElementException("record with id " + bookId + " not found");

        Optional<Book> dbBook = repository.findById(bookId);
        dbBook.get().setBookStockOnHand(dbBook.get().getBookStockOnHand()-1);
        repository.save(dbBook.get());
    }

//    public List<Book> getBooks() {
//
//        List<Book> list = new ArrayList<>();
//        list.add(new Book(1L,new Long(1),new Long(4),new Long(1),"The Pragmatic Programmer","From Journeyman to Master","9780201616224", LocalDate.of(1999, Month.OCTOBER, 30),"1st",352,"USA","English","www.thepragmaticprogrammer.com",125.99));
//        list.add(new Book(2L,new Long(2),new Long(5),new Long(1),"How to Use Objects","Code and Concepts","9780321995546", LocalDate.of(2015, Month.DECEMBER, 15),"1st",832,"USA","English",null,112.69));
//        list.add(new Book(3L,new Long(3),new Long(7),new Long(2),"Pro Spring 5","An In-Depth Guide to the Spring Framework and Its Tools","9781484228074", LocalDate.of(2017, Month.OCTOBER, 17),"5th",878,"GBR","English","prospringfive",421.13));
//        return list;
//    }

//    public Book getBook(String bookId) {
//
//        return new Book(1L,new Long(3),new Long(7),new Long(2),"Pro Spring 5","An In-Depth Guide to the Spring Framework and Its Tools","9781484228074", LocalDate.of(2017, Month.OCTOBER, 17),"5th",878,"GBR","English","prospringfive",421.13);
//    }
}
