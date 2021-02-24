package com.bookcity.book;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Domingos Manuel
 * Date: 24 February 2021
 * BookOrder domain entity
 */
@Entity
@Table
public class BookOrder {

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

    @Nullable
    private LocalDate orderDate;

    @Nullable
    private Double orderAmount;

    public BookOrder() {
    }

    public BookOrder(String orderCustomerName,
                     String orderCustomerAddress,
                     String orderCustomerEmail,
                     Long orderBookId,
                     @Nullable LocalDate orderDate,
                     @Nullable Double orderAmount) {
        this.orderCustomerName = orderCustomerName;
        this.orderCustomerAddress = orderCustomerAddress;
        this.orderCustomerEmail = orderCustomerEmail;
        this.orderBookId = orderBookId;
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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "BookOrder{" +
                "orderId=" + orderId +
                ", orderCustomerName='" + orderCustomerName + '\'' +
                ", orderCustomerAddress='" + orderCustomerAddress + '\'' +
                ", orderCustomerEmail='" + orderCustomerEmail + '\'' +
                ", orderBookId=" + orderBookId +
                ", orderDate=" + orderDate +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
