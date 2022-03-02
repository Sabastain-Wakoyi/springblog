package com.codeup.springblog.controllers;

import org.apache.tomcat.jni.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.codeup.springblog.repositories.UserRepository;

public class UserController{
    private UserRepository users;


    public UserController(UserRepository users){
        this.users = users;

    }

    @GetMapping("/sign-up")
    public String ShowSignupFormat(Model model){
        model.addAttribute("user" , new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        return "redirect:/login";
    }

}
