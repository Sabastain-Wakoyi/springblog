package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "books_genres",
            joinColumns = {@JoinColumn(name="genre_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Book> books;

    public Genre() {
    }

    public Genre(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Genre(long id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}