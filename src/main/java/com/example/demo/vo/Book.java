package com.example.demo.vo;

public class Book {
    private int book_seq;
    private String book_name;
    private String book_img;
    private String book_amount;
    private String book_price;
    private String book_comment;
    private String book_detail;
    private String book_createAt;
    private int cart_seq;
    private String cart_date;
    private int customer_customer_seq;
    private int card_detail_seq;
    private int book_book_seq;
    private int cart_cart_seq;

    public Book(int book_seq, String book_name, String book_img, String book_amount, String book_price, String book_comment, String book_detail, String book_createAt, int cart_seq, String cart_date, int customer_customer_seq, int card_detail_seq, int book_book_seq, int cart_cart_seq) {
        this.book_seq = book_seq;
        this.book_name = book_name;
        this.book_img = book_img;
        this.book_amount = book_amount;
        this.book_price = book_price;
        this.book_comment = book_comment;
        this.book_detail = book_detail;
        this.book_createAt = book_createAt;
        this.cart_seq = cart_seq;
        this.cart_date = cart_date;
        this.customer_customer_seq = customer_customer_seq;
        this.card_detail_seq = card_detail_seq;
        this.book_book_seq = book_book_seq;
        this.cart_cart_seq = cart_cart_seq;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_seq=" + book_seq +
                ", book_name='" + book_name + '\'' +
                ", book_img='" + book_img + '\'' +
                ", book_amount='" + book_amount + '\'' +
                ", book_price='" + book_price + '\'' +
                ", book_comment='" + book_comment + '\'' +
                ", book_detail='" + book_detail + '\'' +
                ", book_createAt='" + book_createAt + '\'' +
                ", cart_seq=" + cart_seq +
                ", cart_date='" + cart_date + '\'' +
                ", customer_customer_seq=" + customer_customer_seq +
                ", card_detail_seq=" + card_detail_seq +
                ", book_book_seq=" + book_book_seq +
                ", cart_cart_seq=" + cart_cart_seq +
                '}';
    }

    public Book() {
    }

    public int getBook_seq() {
        return book_seq;
    }

    public void setBook_seq(int book_seq) {
        this.book_seq = book_seq;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_img() {
        return book_img;
    }

    public void setBook_img(String book_img) {
        this.book_img = book_img;
    }

    public String getBook_amount() {
        return book_amount;
    }

    public void setBook_amount(String book_amount) {
        this.book_amount = book_amount;
    }

    public String getBook_price() {
        return book_price;
    }

    public void setBook_price(String book_price) {
        this.book_price = book_price;
    }

    public String getBook_comment() {
        return book_comment;
    }

    public void setBook_comment(String book_comment) {
        this.book_comment = book_comment;
    }

    public String getBook_detail() {
        return book_detail;
    }

    public void setBook_detail(String book_detail) {
        this.book_detail = book_detail;
    }

    public String getBook_createAt() {
        return book_createAt;
    }

    public void setBook_createAt(String book_createAt) {
        this.book_createAt = book_createAt;
    }

    public int getCart_seq() {
        return cart_seq;
    }

    public void setCart_seq(int cart_seq) {
        this.cart_seq = cart_seq;
    }

    public String getCart_date() {
        return cart_date;
    }

    public void setCart_date(String cart_date) {
        this.cart_date = cart_date;
    }

    public int getCustomer_customer_seq() {
        return customer_customer_seq;
    }

    public void setCustomer_customer_seq(int customer_customer_seq) {
        this.customer_customer_seq = customer_customer_seq;
    }

    public int getCard_detail_seq() {
        return card_detail_seq;
    }

    public void setCard_detail_seq(int card_detail_seq) {
        this.card_detail_seq = card_detail_seq;
    }

    public int getBook_book_seq() {
        return book_book_seq;
    }

    public void setBook_book_seq(int book_book_seq) {
        this.book_book_seq = book_book_seq;
    }

    public int getCart_cart_seq() {
        return cart_cart_seq;
    }

    public void setCart_cart_seq(int cart_cart_seq) {
        this.cart_cart_seq = cart_cart_seq;
    }
}