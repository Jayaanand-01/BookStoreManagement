package com.Project.BookStoreManagement.controller;

import com.Project.BookStoreManagement.entity.Book;
import com.Project.BookStoreManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Bookcontroller{
    @Autowired
    private BookService service;
    @GetMapping("/")
    public String showHome()
    {
        return "Home";
    }
    @GetMapping("/book_register")
    public String bookRegister()
    {
        return "bookRegister";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllbook()
    {
        List<Book>list=service.getAllBook();
        ModelAndView m=new ModelAndView();
        m.setViewName("bookList");
        m.addObject("book",list);
        return new ModelAndView("bookList","book","list");
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b)
    {
        service.save(b);
        return "redirect:/available_books";
    }
}
