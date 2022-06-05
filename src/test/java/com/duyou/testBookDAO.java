package com.duyou;

import com.duyou.dao.BookDAO;
import com.duyou.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class testBookDAO {
    @Autowired
    private BookDAO bookDAO;

    @Test
    public void testFindAll(){
        List<Book> books = bookDAO.selectList(null);
        books.forEach(b->System.out.println("name:"+b.getTitle()));
    }
}
