package com.codeup.springblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController{
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
    public String submitCreateForm(){
        return "view submit form creation";
    }

}

