package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import repositories.BookRepository;

@Controller
public class BookController {
    private BookRepository bookDao;

    public BookController(BookRepository bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/books")
    public String showBooks(Model model) {
        model.addAttribute("allBooks", bookDao.findAll());
        return "books";
    }

    @GetMapping("/books/create")
    public String createBook(Model model){
        model.addAttribute("book", new Book());
        return "books/create";
    }

    @PostMapping("/books/create")
    public String createBook(@ModelAttribute Book book) {
        //book.SetAuthor(authorsDao.getById(1L));
        //books.save(book);
        return "books/index";

    }


}