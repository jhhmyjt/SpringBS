package com.duyou.controller;

import com.duyou.entity.Book;
import com.duyou.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("store")
public class BookController {
    @Autowired
    private BookService bookService;

    //获取所有book
    @CrossOrigin //跨域
    @GetMapping("findAll")
    public List<Book> findAll(){
        List<Book> books = bookService.findAll();
        return books;
    }
}
