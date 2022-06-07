package com.duyou.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duyou.dao.BookDAO;
import com.duyou.entity.Book;
import com.duyou.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Book> findAll() {
        return bookDAO.selectList(null);
    }

    @Override
    public Book findByName() {
        QueryWrapper<Book> queryWrapper=new QueryWrapper<>();
        //等值查询
        queryWrapper.eq("id",1);
        return bookDAO.selectList(queryWrapper).get(0);
    }

    @Override
    public void addBook(Book book) {
        bookDAO.insert(book);
    }
}
