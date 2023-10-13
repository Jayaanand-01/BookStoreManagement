package com.Project.BookStoreManagement.service;

import com.Project.BookStoreManagement.entity.Book;
import com.Project.BookStoreManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
@Autowired
private BookRepository brepo;
    public void save(Book b)
    {
        brepo.save(b);
    }
    public List<Book> getAllBook()
    {
        return brepo.findAll();
    }
}
