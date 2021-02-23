package com.domingosm.bookcity.bookorder;

import com.domingosm.bookcity.book.Book;

import java.time.LocalDate;

public class BookOrderResponse {

    private Long orderId;
    private String orderCustomerName;
    private String orderCustomerAddress;
    private String orderCustomerEmail;
    private LocalDate orderDate;
    private Double orderAmount;
    private Long orderBookId;
    private Book book;
    private Integer responseCode;
    private String responseMessage;

    public BookOrderResponse() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderCustomerName() {
        return orderCustomerName;
    }

    public void setOrderCustomerName(String orderCustomerName) {
        this.orderCustomerName = orderCustomerName;
    }

    public String getOrderCustomerAddress() {
        return orderCustomerAddress;
    }

    public void setOrderCustomerAddress(String orderCustomerAddress) {
        this.orderCustomerAddress = orderCustomerAddress;
    }

    public String getOrderCustomerEmail() {
        return orderCustomerEmail;
    }

    public void setOrderCustomerEmail(String orderCustomerEmail) {
        this.orderCustomerEmail = orderCustomerEmail;
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

    public Long getOrderBookId() {
        return orderBookId;
    }

    public void setOrderBookId(Long orderBookId) {
        this.orderBookId = orderBookId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Override
    public String toString() {
        return "BookOrderResponse{" +
                "orderId=" + orderId +
                ", orderCustomerName='" + orderCustomerName + '\'' +
                ", orderCustomerAddress='" + orderCustomerAddress + '\'' +
                ", orderCustomerEmail='" + orderCustomerEmail + '\'' +
                ", orderDate=" + orderDate +
                ", orderAmount=" + orderAmount +
                ", orderBookId=" + orderBookId +
                ", book=" + book +
                ", responseCode=" + responseCode +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }
}
