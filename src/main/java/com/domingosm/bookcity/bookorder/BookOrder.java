package com.domingosm.bookcity.bookorder;

import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate orderDate;
    private Double orderAmount;
    private Long orderBookId;
    private String orderBookTitle;

    public BookOrder() {
    }

    public BookOrder(String orderCustomerName,
                     String orderCustomerAddress,
                     String orderCustomerEmail,
                     LocalDate orderDate,
                     Double orderAmount,
                     Long orderBookId,
                     String orderBookTitle) {
        this.orderCustomerName = orderCustomerName;
        this.orderCustomerAddress = orderCustomerAddress;
        this.orderCustomerEmail = orderCustomerEmail;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.orderBookId = orderBookId;
        this.orderBookTitle = orderBookTitle;
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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Long getOrderBookId() {
        return orderBookId;
    }

    public String getOrderBookTitle() {
        return orderBookTitle;
    }

    @Override
    public String toString() {
        return "BookOrder{" +
                "orderId=" + orderId +
                ", orderCustomerName='" + orderCustomerName + '\'' +
                ", orderCustomerAddress='" + orderCustomerAddress + '\'' +
                ", orderCustomerEmail='" + orderCustomerEmail + '\'' +
                ", orderDate=" + orderDate +
                ", orderAmount=" + orderAmount +
                ", orderBookId=" + orderBookId +
                ", orderBookTitle='" + orderBookTitle + '\'' +
                '}';
    }
}
