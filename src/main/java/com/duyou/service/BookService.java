package com.duyou.service;

import com.duyou.entity.Book;

import java.util.List;

public interface BookService {
    //获取所有数据
    List<Book> findAll();
    //按名称查找数据
    Book findByName();
    //添加数据
    void addBook(Book book);
}
