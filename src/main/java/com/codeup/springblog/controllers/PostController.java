package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import repositories.PostRepository;

@Controller
public class PostController{
    private PostRepository postsDao;

    public PostController(){

    }

    @GetMapping("/posts")
    @ResponseBody
    public String viewPost(){
        return "post/index";
    }


    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postDetails(@PathVariable long id){
        return "post/show";

    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String showCreateForm(){
        return "view form for post creation";

    }

    @PostMapping("/posts")
    @ResponseBody

    Post newPost = new Post(title, body);
    public String submitCreateForm(){
        return "view submit form creation";
    }

}

