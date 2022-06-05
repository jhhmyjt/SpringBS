package com.duyou;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duyou.dao.UserDAO;
import com.duyou.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class testUserDAO {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void testSaveUser(){
        User user=new User();
        user.setName("Jack").setEmail("111@qq.com").setPassword("123456");
        userDAO.insert(user);
        List<User> users = userDAO.selectList(null);
        users.forEach(u->System.out.println("user name:"+u.getName()));
    }

    //条件查询
    @Test
    public void testFind(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        //等值查询
        queryWrapper.eq("name","admin3");
        List<User> users = userDAO.selectList(queryWrapper);
        if(users.isEmpty()){
            System.out.println("is empty");
        }
        users.forEach(u->System.out.println("name:"+u.getName()));
    }
}
