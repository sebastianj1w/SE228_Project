package ebookBackend.RESTfulService.controller;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private String ID;
    private String publishDate;
    private String abstraction;
    private String catalogue;
    private float price;
    private float rate;
    private float words;
    private int stock;
    private long ISBN;


    public Book() {
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

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setWords(float words) {
        this.words = words;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setISBN(long isbn) {
        this.ISBN = isbn;
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

    public float getPrice() {
        return price;
    }

    public float getRate() {
        return rate;
    }

    public float getWords() {
        return words;
    }

    public int getStock() {
        return stock;
    }

    public long getISBN() {
        return ISBN;
    }
}