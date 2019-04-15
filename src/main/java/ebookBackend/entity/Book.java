package ebookBackend.entity;

import java.math.BigDecimal;

public class Book {
    private String ID;
    private String title;
    private String author;
    private String publisher;
    private String publishDate;
    private String abstraction;
    private String catalogue;
    private double rate;
    private double words;
    private BigDecimal price;
    private int stock;
    private String ISBN;

    public Book() {
    }

    public Book(BookBasic basic, BookDetail detail) {
        this.title = basic.getTitle();
        this.author = basic.getAuthor();
        this.publisher = basic.getPublisher();
        this.ID = basic.getId();
        this.ISBN = basic.getIsbn();
        this.rate = detail.getRate();
        this.abstraction = detail.getAbstraction();
        this.catalogue = detail.getCatalogue();
        this.words = detail.getWords();
        this.publishDate = detail.getPublishdate();
        this.price = basic.getPrice();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setISBN(String isbn) {
        this.ISBN = isbn;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPublishDate(String PD) {
        publishDate = PD;
    }

    public void setAbstraction(String ab) {
        abstraction = ab;
    }

    public void setCatalogue(String catalogue) {
        this.catalogue = catalogue;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setWords(float words) {
        this.words = words;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getID() {
        return ID;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getAbstraction() {
        return abstraction;
    }

    public String getCatalogue() {
        return catalogue;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public double getRate() {
        return rate;
    }

    public double getWords() {
        return words;
    }
}
