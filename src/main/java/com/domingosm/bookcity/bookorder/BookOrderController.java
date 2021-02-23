package com.domingosm.bookcity.bookorder;

import com.domingosm.bookcity.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api.bookcity.com/book-orders")
public class BookOrderController {

    private final BookService bookService;
    private final BookOrderService bookOrderService;

    @Autowired
    public BookOrderController(BookService bookService, BookOrderService bookOrderService) {
        this.bookService = bookService;
        this.bookOrderService = bookOrderService;
    }

    @GetMapping
    public List<BookOrder> getOrders() {
        return bookOrderService.getOrders();
    }

    @PostMapping
    public void placeOrder(@RequestBody BookOrder bookOrder) {
        bookOrderService.placeOrder(bookOrder);
        bookService.updateQuantity(bookOrder.getOrderBookId());
    }
}
