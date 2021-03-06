package com.bookcity.book.service;

import com.bookcity.book.dao.BookRepository;
import com.bookcity.book.dao.OrderRepository;
import com.bookcity.book.entity.Book;
import com.bookcity.book.entity.Order;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Domingos Manuel
 * Date: 24 February 2021
 * Book Service class
 */
@Service
public class BookService {

    private static final Logger LOGGER = Logger.getLogger(BookService.class.getName());

    @Autowired
    private BookRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public Book getBook(Long bookId) {
        Optional<Book> book = Optional.of(repository.findById(bookId)).orElse(null);
        if (book == null) {
            String message = String.format("ERROR: Book entry with id %s not found", String.valueOf(bookId));
            LOGGER.log(Level.ALL, message);
            return null;
        }

        return book.get();
    }

    public void addBook(Book book) {
        //try to save the duplicate. let the db handle this
//        List<Book> bookList = repository.findAll();
//        bookList.forEach(dbBook -> {
//            if (dbBook.equals(book)) {
//                String response = String.format("ERROR: Book entry with title %s already exists", dbBook.getBookTitle());
//                throw new ConcurrentModificationException(response);crap
//            }
//        });
        repository.save(book);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll().stream().collect(Collectors.toList());
    }

    public Order getOrder(Long orderId) {
        Optional<Order> order = Optional.of(orderRepository.findById(orderId)).orElse(null);
        if (order == null) {
            String message = String.format("ERROR: Order entry with id %s not found", String.valueOf(orderId));
            LOGGER.log(Level.ALL, message);
            return null;
        }

        return order.get();
    }

    public void placeOrder(Order order) {

        Optional<Book> book = Optional.of(repository.findById(order.getOrderBookId()).orElse(null));
        if (!isSellingOk(order, book)) {
            return;
        }

        order.setOrderDate(LocalDate.now());
        order.setOrderAmount(book.get().getBookSellingPrice());
        orderRepository.save(order);
    }

    private boolean isSellingOk(Order order, Optional<Book> dbBook) {

        Long bookId = order.getOrderBookId();
        Integer orderQuantity = order.getOrderQuantity();

        if (dbBook == null) {
            String message = String.format("ERROR: Book entry with id %s not found", String.valueOf(bookId));
            LOGGER.log(Level.ALL, message);
            return false;

        }
        if (dbBook.get().getBookStockOnHand() <= 0) { //ensure at DB level
            String message = String.format("ERROR: No stock for book %s", dbBook.get().getBookTitle());
            LOGGER.log(Level.ALL, message);
            return false;
        }
        if (dbBook.get().getBookStockOnHand() < orderQuantity) { //ensure at DB level
            String message = String.format("ERROR: Not enough stock for book %s. Can only take %d copies", dbBook.get().getBookTitle(), dbBook.get().getBookStockOnHand());
            LOGGER.log(Level.ALL, message);
            return false;
        }

        dbBook.get().setBookStockOnHand(dbBook.get().getBookStockOnHand()-orderQuantity);
        repository.save(dbBook.get());

        return true;
    }

}
