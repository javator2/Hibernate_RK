package pl.sdacademy.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "category") //wlascicielem relacji jest klasa Book
    private Set<Book> bookSet;

    public Category(String name) {
        this.name = name;
    }
    public Category(){}

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
}
