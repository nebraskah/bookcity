package com.domingosm.bookcity.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ConcurrentModificationException;
import java.util.List;
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

    public BookResponse getBook(Long bookId) {
        boolean exists = repository.existsById(bookId);
        if (!exists) {
            BookResponse br = new BookResponse();
            br.setBookId(bookId);
            br.setResponseCode(HttpStatus.NOT_FOUND.value());
            br.setResponseMessage(String.format("ERROR: Book entry with id %s not found", String.valueOf(bookId)));
            return br;
        }

        Optional<Book> book = repository.findById(bookId);
        BookResponse br = new BookResponse();
        br.setBookId(book.get().getBookId());
        br.setBookTitle(book.get().getBookTitle());
        br.setBookDescription(book.get().getBookDescription());
        br.setBookGenre(book.get().getBookGenre());
        br.setBookIsbn(book.get().getBookIsbn());
        br.setBookPublisher(book.get().getBookPublisher());
        br.setBookPublishDate(book.get().getBookPublishDate());
        br.setBookEdition(book.get().getBookEdition());
        br.setBookPageCount(book.get().getBookPageCount());
        br.setBookCountry(book.get().getBookCountry());
        br.setBookLanguage(book.get().getBookLanguage());
        br.setBookWebsite(book.get().getBookWebsite());
        br.setBookAuthor(book.get().getBookAuthor());
        br.setBookSellingPrice(book.get().getBookSellingPrice());
        br.setBookStockOnHand(book.get().getBookStockOnHand());
        br.setResponseCode(HttpStatus.OK.value());
        br.setResponseMessage("SUCCESS");
        return br;
    }

    public void addBook(Book book) {
        List<Book> bookList = repository.findAll();
        bookList.forEach(dbBook -> {
            if (dbBook.equals(book)) {
                String response = String.format("ERROR: Book entry with title %s already exists", dbBook.getBookTitle());
                throw new ConcurrentModificationException(response);
            }
        });
        repository.save(book);
    }

    public void updateQuantity(Long bookId) {
//        boolean exists = repository.existsById(bookId);
//        if (!exists)
//            throw new NoSuchElementException("record with id " + bookId + " not found");

        Optional<Book> dbBook = repository.findById(bookId);
        dbBook.get().setBookStockOnHand(dbBook.get().getBookStockOnHand()-1);
        repository.save(dbBook.get());
    }

}
