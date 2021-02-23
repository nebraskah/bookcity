package com.domingosm.bookcity.book;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
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

    public Book() {
    }

    public Book(String bookTitle,
                String bookDescription,
                String bookGenre,
                String bookIsbn,
                String bookPublisher,
                LocalDate bookPublishDate,
                String bookEdition,
                Integer bookPageCount,
                String bookCountry,
                String bookLanguage,
                String bookWebsite,
                String bookAuthor,
                Double bookSellingPrice,
                Integer bookStockOnHand) {
        this.bookTitle = bookTitle;
        this.bookDescription = bookDescription;
        this.bookGenre = bookGenre;
        this.bookIsbn = bookIsbn;
        this.bookPublisher = bookPublisher;
        this.bookPublishDate = bookPublishDate;
        this.bookEdition = bookEdition;
        this.bookPageCount = bookPageCount;
        this.bookCountry = bookCountry;
        this.bookLanguage = bookLanguage;
        this.bookWebsite = bookWebsite;
        this.bookAuthor = bookAuthor;
        this.bookSellingPrice = bookSellingPrice;
        this.bookStockOnHand = bookStockOnHand;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public LocalDate getBookPublishDate() {
        return bookPublishDate;
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

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Double getBookSellingPrice() {
        return bookSellingPrice;
    }

    public Integer getBookStockOnHand() {
        return bookStockOnHand;
    }

    public void setBookStockOnHand(Integer bookStockOnHand) {
        this.bookStockOnHand = bookStockOnHand;
    }

    @Override
    public String toString() {
        return "Book{" +
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
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (Book.class.isInstance(obj)) {
            Book book = (Book) obj;
            return bookTitle.equalsIgnoreCase(book.bookTitle)
                    && bookAuthor.equalsIgnoreCase(book.bookAuthor)
                    && bookIsbn.equalsIgnoreCase(book.bookIsbn);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookTitle, bookAuthor, bookIsbn);
    }
}
