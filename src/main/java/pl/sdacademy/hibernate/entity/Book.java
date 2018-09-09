package pl.sdacademy.hibernate.entity;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tytul")
    private String title;
    @Column
    private String isbn;
    @Column
    private String author;
    @ManyToOne(cascade = CascadeType.ALL) //dodajemy kaskadowosc aby utworzylo kategorie a pozniej dodalo ksiazki
    private Category category;
    @ManyToOne(cascade = CascadeType.ALL)
    private Publisher publisher;

    public Book(String title, String isbn, String author, Category category, Publisher publisher) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
    }
    public Book(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
