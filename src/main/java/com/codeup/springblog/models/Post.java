package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, columnDefinition = "Text")
    private String body;

    @Column(nullable = false, length = 150)
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Post() {

    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;

    }


    public Post(String title, String body, long id) {
        this.id = id;
        this.title = title;
        this.body = body;

    }

    public Post(int i, String codeup, String s) {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsers() {
        User users = null;
        return users;
    }

    public void setUsers(User users) {
        this.user = users;
    }

    public void setPost(User user) {
    }

    public Book getPost() {
        return null;
    }
}
