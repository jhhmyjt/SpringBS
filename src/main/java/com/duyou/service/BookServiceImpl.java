package com.duyou.service;

import com.duyou.dao.BookDAO;
import com.duyou.entity.Book;
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
}
