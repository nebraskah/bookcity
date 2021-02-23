package com.domingosm.bookcity.bookorder;

import com.domingosm.bookcity.book.Book;
import com.domingosm.bookcity.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookOrderService {

    private final BookRepository bookRepository;
    private final BookOrderRepository repository;

    @Autowired
    public BookOrderService(BookRepository bookRepository, BookOrderRepository repository) {
        this.bookRepository = bookRepository;
        this.repository = repository;
    }

    public List<BookOrder> getOrders() {
        return repository.findAll();
    }

    public void placeOrder(BookOrder bookOrder) {

        Book book = getBook(bookOrder.getOrderBookId());
        bookOrder.setOrderAmount(book.getBookSellingPrice());
        repository.save(bookOrder);
    }

    private Book getBook(Long bookId) {
        boolean exists = repository.existsById(bookId);
        if (!exists)
            throw new NoSuchElementException("record with id " + bookId + " not found");

        Optional<Book> book = bookRepository.findById(bookId);
        return book.get();
    }

}
