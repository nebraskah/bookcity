package com.bookcity.book.controller;

import com.bookcity.book.Book;
import com.bookcity.book.BookOrder;
import com.bookcity.book.BookOrderResponse;
import com.bookcity.book.BookResponse;
import com.bookcity.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api.bookcity.com")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(path = "/books/{bookId}")
    public BookResponse getBook(@PathVariable ("bookId") Long bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping(path = "/books")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping(path = "/orders")
    public List<BookOrderResponse> getOrders() {
        return bookService.getOrders();
    }

    @GetMapping(path = "/orders/{orderId}")
    public BookOrderResponse getOrder(@PathVariable ("orderId") Long orderId) {
        return bookService.getOrder(orderId);
    }

    @PostMapping(path = "/orders")
    public void placeOrder(@RequestBody BookOrder bookOrder) {
        bookService.updateQuantity(bookOrder.getOrderBookId());
        bookService.placeOrder(bookOrder);
    }
}
