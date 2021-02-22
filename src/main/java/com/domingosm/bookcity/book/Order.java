package com.domingosm.bookcity.book;

import java.time.LocalDate;

public class Order {

    private Long orderId;
    private Long orderBook;
    private Long orderCustomer;
    private LocalDate orderDate;
    private Integer orderQty;
    private Double orderDeliveryCharge;
    private Double orderTotalPrice;

//    public Order() {
//    }

    public Order(Long orderBook,
                 Long orderCustomer,
                 LocalDate orderDate,
                 Integer orderQty,
                 Double orderDeliveryCharge,
                 Double orderTotalPrice) {
        this.orderBook = orderBook;
        this.orderCustomer = orderCustomer;
        this.orderDate = orderDate;
        this.orderQty = orderQty;
        this.orderDeliveryCharge = orderDeliveryCharge;
        this.orderTotalPrice = orderTotalPrice;
    }

    public Order(Long orderId,
                 Long orderBook,
                 Long orderCustomer,
                 LocalDate orderDate,
                 Integer orderQty,
                 Double orderDeliveryCharge,
                 Double orderTotalPrice) {
        this.orderId = orderId;
        this.orderBook = orderBook;
        this.orderCustomer = orderCustomer;
        this.orderDate = orderDate;
        this.orderQty = orderQty;
        this.orderDeliveryCharge = orderDeliveryCharge;
        this.orderTotalPrice = orderTotalPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getOrderBook() {
        return orderBook;
    }

    public Long getOrderCustomer() {
        return orderCustomer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public Double getOrderDeliveryCharge() {
        return orderDeliveryCharge;
    }

    public Double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderBook=" + orderBook +
                ", orderCustomer=" + orderCustomer +
                ", orderDate=" + orderDate +
                ", orderQty=" + orderQty +
                ", orderDeliveryCharge=" + orderDeliveryCharge +
                ", orderTotalPrice=" + orderTotalPrice +
                '}';
    }
}
