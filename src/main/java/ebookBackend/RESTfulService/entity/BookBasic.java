package ebookBackend.RESTfulService.entity;

public class BookBasic {
    private String title;
    private String author;
    private String publisher;
    private String ID;
    private float price;
    private int stock;
    private long ISBN;


    public BookBasic(Book b) {
        this.title = b.getTitle();
        this.author = b.getAuthor();
        this.publisher = b.getPublisher();
        this.ID = b.getID();
        this.price = b.getPrice();
        this.ISBN = b.getISBN();
        this.stock = b.getStock();
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

    public void setPrice(float price) {
        this.price = price;
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

    public float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public long getISBN() {
        return ISBN;
    }
}
