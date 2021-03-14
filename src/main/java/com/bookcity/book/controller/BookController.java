package com.bookcity.book.controller;

import com.bookcity.book.entity.Book;
import com.bookcity.book.entity.Order;
import com.bookcity.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Domingos Manuel
 * Date: 24 February 2021
 * BookController class
 */
@RestController
@RequestMapping("/api.bookcity.com")
public class BookController {

    //Fix JUnit tests
    //Order list of books
    //enforce DB constraints
    //AWS deployment
    //Angular UI

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(path = "/books/{bookId}")
    public Book getBook(@PathVariable ("bookId") Long bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping(path = "/books")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping(path = "/orders")
    public List<Order> getOrders() {
        return bookService.getOrders();
    }

    @GetMapping(path = "/orders/{orderId}")
    public Order getOrder(@PathVariable ("orderId") Long orderId) {
        return bookService.getOrder(orderId);
    }

    @PostMapping(path = "/orders")
    public void placeOrder(@RequestBody Order order) {
        bookService.placeOrder(order);
    }
}
