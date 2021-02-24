package com.bookcity.book.service;

import com.bookcity.book.Book;
import com.bookcity.book.BookOrder;
import com.bookcity.book.BookOrderResponse;
import com.bookcity.book.BookResponse;
import com.bookcity.book.dao.BookOrderRepository;
import com.bookcity.book.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookOrderRepository orderRepository;

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

        Optional<Book> dbBook = repository.findById(bookId);
        if (dbBook.get().getBookStockOnHand() <= 0) {
            String response = String.format("ERROR: No stock for book %s", dbBook.get().getBookTitle());
            throw new UnsupportedOperationException(response);
        }
        dbBook.get().setBookStockOnHand(dbBook.get().getBookStockOnHand()-1);
        repository.save(dbBook.get());
    }

    public List<BookOrderResponse> getOrders() {

        List<BookOrderResponse> response = new ArrayList<>();
        for (BookOrder bookOrder : orderRepository.findAll()) {
            Book book = findBook(bookOrder.getOrderBookId());

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

    public BookOrderResponse getOrder(Long orderId) {
        boolean exists = orderRepository.existsById(orderId);
        if (!exists) {
            BookOrderResponse bor = new BookOrderResponse();
            bor.setOrderId(orderId);
            bor.setResponseCode(HttpStatus.NOT_FOUND.value());
            bor.setResponseMessage(String.format("ERROR: Order entry with id %s not found", String.valueOf(orderId)));
            return bor;
        }

        Optional<BookOrder> bookOrder = orderRepository.findById(orderId);
        BookOrderResponse boResponse = new BookOrderResponse();
        boResponse.setOrderId(bookOrder.get().getOrderId());
        boResponse.setOrderCustomerName(bookOrder.get().getOrderCustomerName());
        boResponse.setOrderCustomerAddress(bookOrder.get().getOrderCustomerAddress());
        boResponse.setOrderCustomerEmail(bookOrder.get().getOrderCustomerEmail());
        boResponse.setOrderDate(bookOrder.get().getOrderDate());
        boResponse.setOrderAmount(bookOrder.get().getOrderAmount());
        boResponse.setBook(findBook(bookOrder.get().getOrderBookId()));
        boResponse.setResponseCode(HttpStatus.OK.value());
        boResponse.setResponseMessage("SUCCESS");
        return boResponse;
    }

    public void placeOrder(BookOrder bookOrder) {

        Book book = findBook(bookOrder.getOrderBookId());
        if (book == null)
            throw new NoSuchElementException(String.format("ERROR: Book entry with id %s not found", String.valueOf(bookOrder.getOrderBookId())));

        bookOrder.setOrderDate(LocalDate.now());
        bookOrder.setOrderAmount(book.getBookSellingPrice());
        orderRepository.save(bookOrder);
    }

    private Book findBook(Long bookId) {
        boolean exists = repository.existsById(bookId);
        if (!exists)
            return null;

        Optional<Book> book = repository.findById(bookId);
        return book.get();
    }

}
