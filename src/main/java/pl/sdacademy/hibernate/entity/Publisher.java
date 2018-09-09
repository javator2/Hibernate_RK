package pl.sdacademy.hibernate.entity;

import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Publisher {
    private int id;
    private String name;
    private String address;
    private String city;
    private Set<Book> bookSet;
}
