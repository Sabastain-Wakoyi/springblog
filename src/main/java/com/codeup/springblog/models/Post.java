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

}
