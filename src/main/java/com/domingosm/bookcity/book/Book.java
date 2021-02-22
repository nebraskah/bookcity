package com.domingosm.bookcity.book;

import java.util.Objects;

public class Book {

    private Long bookId;
    private Long bookAuthor;
    private Long bookGenre;
    private Long bookPublisher;
    private String bookTitle;
    private String bookDescription;
    private String bookIsbn;
    private String bookPublishingDate;
    private String bookEdition;
    private Integer bookPageCount;
    private String bookCountry;
    private String bookLanguage;
    private String bookWebsite;
    private Double bookSellingPrice;

//    public Book() {
//    }

    public Book(Long bookAuthor,
                Long bookGenre,
                Long bookPublisher,
                String bookTitle,
                String bookDescription,
                String bookIsbn,
                String bookPublishingDate,
                String bookEdition,
                Integer bookPageCount,
                String bookCountry,
                String bookLanguage,
                String bookWebsite,
                Double bookSellingPrice) {
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.bookPublisher = bookPublisher;
        this.bookTitle = bookTitle;
        this.bookDescription = bookDescription;
        this.bookIsbn = bookIsbn;
        this.bookPublishingDate = bookPublishingDate;
        this.bookEdition = bookEdition;
        this.bookPageCount = bookPageCount;
        this.bookCountry = bookCountry;
        this.bookLanguage = bookLanguage;
        this.bookWebsite = bookWebsite;
        this.bookSellingPrice = bookSellingPrice;
    }

    public Book(Long bookId,
                Long bookAuthor,
                Long bookGenre,
                Long bookPublisher,
                String bookTitle,
                String bookDescription,
                String bookIsbn,
                String bookPublishingDate,
                String bookEdition,
                Integer bookPageCount,
                String bookCountry,
                String bookLanguage,
                String bookWebsite,
                Double bookSellingPrice) {
        this.bookId = bookId;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.bookPublisher = bookPublisher;
        this.bookTitle = bookTitle;
        this.bookDescription = bookDescription;
        this.bookIsbn = bookIsbn;
        this.bookPublishingDate = bookPublishingDate;
        this.bookEdition = bookEdition;
        this.bookPageCount = bookPageCount;
        this.bookCountry = bookCountry;
        this.bookLanguage = bookLanguage;
        this.bookWebsite = bookWebsite;
        this.bookSellingPrice = bookSellingPrice;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getBookAuthor() {
        return bookAuthor;
    }

    public Long getBookGenre() {
        return bookGenre;
    }

    public Long getBookPublisher() {
        return bookPublisher;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public String getBookPublishingDate() {
        return bookPublishingDate;
    }

    public String getBookEdition() {
        return bookEdition;
    }

    public Integer getBookPageCount() {
        return bookPageCount;
    }

    public String getBookCountry() {
        return bookCountry;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public String getBookWebsite() {
        return bookWebsite;
    }

    public Double getBookSellingPrice() {
        return bookSellingPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookAuthor=" + bookAuthor +
                ", bookGenre=" + bookGenre +
                ", bookPublisher=" + bookPublisher +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", bookPublishingDate='" + bookPublishingDate + '\'' +
                ", bookEdition='" + bookEdition + '\'' +
                ", bookPageCount=" + bookPageCount +
                ", bookCountry='" + bookCountry + '\'' +
                ", bookLanguage='" + bookLanguage + '\'' +
                ", bookWebsite='" + bookWebsite + '\'' +
                ", bookSellingPrice=" + bookSellingPrice +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (Book.class.isInstance(obj)) {
            Book book = (Book) obj;
            return bookTitle.equalsIgnoreCase(book.bookTitle)
                    && bookIsbn.equalsIgnoreCase(book.bookIsbn);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookTitle, bookIsbn);
    }
}
