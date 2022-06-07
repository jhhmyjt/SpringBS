package com.duyou.controller;

import com.duyou.entity.Book;
import com.duyou.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("store")
@CrossOrigin //跨域
public class BookController {
    @Autowired
    private BookService bookService;

    //获取所有book
    @GetMapping("findAll")
    public List<Book> findAll(){
        List<Book> books = bookService.findAll();
        return books;
    }

    //获取单个book
    @GetMapping("findByName")
    public Book findByName(){
        Book book=bookService.findByName();
        return book;
    }
    //添加book
    @PostMapping("addBook")
    public Map<String,Object> addBook(@RequestBody Book book){
        Map<String,Object> map=new HashMap<>();
        try {
            bookService.addBook(book);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message","Failure.");
        }
        return map;
    }
}
