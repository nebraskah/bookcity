package com.domingosm.bookcity.book;

public class Stock {

    private Long stockId;
    private Long stockBook;
    private Integer stockOnHand;

//    public Stock() {
//    }

    public Stock(Long stockBook,
                 Integer stockOnHand) {
        this.stockBook = stockBook;
        this.stockOnHand = stockOnHand;
    }

    public Stock(Long stockId,
                 Long stockBook,
                 Integer stockOnHand) {
        this.stockId = stockId;
        this.stockBook = stockBook;
        this.stockOnHand = stockOnHand;
    }

    public Long getStockId() {
        return stockId;
    }

    public Long getStockBook() {
        return stockBook;
    }

    public Integer getStockOnHand() {
        return stockOnHand;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", stockBook=" + stockBook +
                ", stockOnHand=" + stockOnHand +
                '}';
    }
}
