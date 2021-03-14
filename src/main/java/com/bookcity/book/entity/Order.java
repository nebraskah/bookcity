package com.bookcity.book.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Domingos Manuel
 * Date: 06 March 2021
 * Order domain entity
 */
@Entity
@Table(name="book_order")
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long orderId;
    private String orderCustomerName;
    private String orderCustomerAddress;
    private String orderCustomerEmail;
    private Long orderBookId;
    private Integer orderQuantity;

    @Nullable
    private LocalDate orderDate;

    @Nullable
    private Double orderAmount;

    public Order() {
    }

    public Order(String orderCustomerName,
                 String orderCustomerAddress,
                 String orderCustomerEmail,
                 Long orderBookId,
                 Integer orderQuantity,
                 @Nullable LocalDate orderDate,
                 @Nullable Double orderAmount) {
        this.orderCustomerName = orderCustomerName;
        this.orderCustomerAddress = orderCustomerAddress;
        this.orderCustomerEmail = orderCustomerEmail;
        this.orderBookId = orderBookId;
        this.orderQuantity = orderQuantity;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getOrderCustomerName() {
        return orderCustomerName;
    }

    public String getOrderCustomerAddress() {
        return orderCustomerAddress;
    }

    public String getOrderCustomerEmail() {
        return orderCustomerEmail;
    }

    public Long getOrderBookId() {
        return orderBookId;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    @Nullable
    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Nullable
    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderCustomerName='" + orderCustomerName + '\'' +
                ", orderCustomerAddress='" + orderCustomerAddress + '\'' +
                ", orderCustomerEmail='" + orderCustomerEmail + '\'' +
                ", orderBookId=" + orderBookId +
                ", orderQuantity=" + orderQuantity +
                ", orderDate=" + orderDate +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
