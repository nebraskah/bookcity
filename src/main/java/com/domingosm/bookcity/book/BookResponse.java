package com.domingosm.bookcity.book;

import java.time.LocalDate;

public class BookResponse {

    private Long bookId;
    private String bookTitle;
    private String bookDescription;
    private String bookGenre;
    private String bookIsbn;
    private String bookPublisher;
    private LocalDate bookPublishDate;
    private String bookEdition;
    private Integer bookPageCount;
    private String bookCountry;
    private String bookLanguage;
    private String bookWebsite;
    private String bookAuthor;
    private Double bookSellingPrice;
    private Integer bookStockOnHand;
    private Integer responseCode;
    private String responseMessage;

    public BookResponse() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public LocalDate getBookPublishDate() {
        return bookPublishDate;
    }

    public void setBookPublishDate(LocalDate bookPublishDate) {
        this.bookPublishDate = bookPublishDate;
    }

    public String getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(String bookEdition) {
        this.bookEdition = bookEdition;
    }

    public Integer getBookPageCount() {
        return bookPageCount;
    }

    public void setBookPageCount(Integer bookPageCount) {
        this.bookPageCount = bookPageCount;
    }

    public String getBookCountry() {
        return bookCountry;
    }

    public void setBookCountry(String bookCountry) {
        this.bookCountry = bookCountry;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public String getBookWebsite() {
        return bookWebsite;
    }

    public void setBookWebsite(String bookWebsite) {
        this.bookWebsite = bookWebsite;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Double getBookSellingPrice() {
        return bookSellingPrice;
    }

    public void setBookSellingPrice(Double bookSellingPrice) {
        this.bookSellingPrice = bookSellingPrice;
    }

    public Integer getBookStockOnHand() {
        return bookStockOnHand;
    }

    public void setBookStockOnHand(Integer bookStockOnHand) {
        this.bookStockOnHand = bookStockOnHand;
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
        return "BookResponse{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", bookGenre='" + bookGenre + '\'' +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", bookPublisher='" + bookPublisher + '\'' +
                ", bookPublishDate=" + bookPublishDate +
                ", bookEdition='" + bookEdition + '\'' +
                ", bookPageCount=" + bookPageCount +
                ", bookCountry='" + bookCountry + '\'' +
                ", bookLanguage='" + bookLanguage + '\'' +
                ", bookWebsite='" + bookWebsite + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookSellingPrice=" + bookSellingPrice +
                ", bookStockOnHand=" + bookStockOnHand +
                ", responseCode=" + responseCode +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }
}
