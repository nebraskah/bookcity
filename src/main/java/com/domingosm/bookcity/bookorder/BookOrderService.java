package com.domingosm.bookcity.bookorder;

import com.domingosm.bookcity.book.Book;
import com.domingosm.bookcity.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookOrderService {

    private final BookRepository bookRepository;
    private final BookOrderRepository repository;

    @Autowired
    public BookOrderService(BookRepository bookRepository,
                            BookOrderRepository repository) {
        this.bookRepository = bookRepository;
        this.repository = repository;
    }

    public List<BookOrderResponse> getOrders() {

        List<BookOrderResponse> response = new ArrayList<>();
        for (BookOrder bookOrder : repository.findAll()) {
            Book book = getBook(bookOrder.getOrderBookId());

            BookOrderResponse boResponse = new BookOrderResponse();
            boResponse.setOrderId(bookOrder.getOrderId());
            boResponse.setOrderCustomerName(bookOrder.getOrderCustomerName());
            boResponse.setOrderCustomerAddress(bookOrder.getOrderCustomerAddress());
            boResponse.setOrderCustomerEmail(bookOrder.getOrderCustomerEmail());
            boResponse.setOrderDate(bookOrder.getOrderDate());
            boResponse.setOrderAmount(bookOrder.getOrderAmount());
            boResponse.setBook(book);
            boResponse.setResponseCode(book == null ? HttpStatus.NOT_FOUND.value() :  HttpStatus.OK.value());

            String responseMessage = book == null ? String.format("ERROR: Book entry with id %s not found", String.valueOf(bookOrder.getOrderBookId())) :  "SUCCESS";
            boResponse.setResponseMessage(responseMessage);

            response.add(boResponse);
        }
        return response;
    }

    public void placeOrder(BookOrder bookOrder) {

        Book book = getBook(bookOrder.getOrderBookId());
        if (book == null)
            throw new NoSuchElementException(String.format("ERROR: Book entry with id %s not found", String.valueOf(bookOrder.getOrderBookId())));

        bookOrder.setOrderAmount(book.getBookSellingPrice());
        repository.save(bookOrder);
    }

    public Book getBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if (!exists)
            return null;

        Optional<Book> book = bookRepository.findById(bookId);
        return book.get();
    }

}
