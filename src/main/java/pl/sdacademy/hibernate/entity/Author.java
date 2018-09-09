package pl.sdacademy.hibernate.entity;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Author {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private String lastname;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> bookSet;

    public Author(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    public Author(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
