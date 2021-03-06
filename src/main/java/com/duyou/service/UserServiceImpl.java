package com.duyou.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duyou.dao.UserDAO;
import com.duyou.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public void addUser(User user) {
        userDAO.insert(user);
    }

    @Override
    public List<User> findByName(String name) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        //等值查询
        queryWrapper.eq("name",name);
        return userDAO.selectList(queryWrapper);
    }

    @Override
    public User findById() {
        return userDAO.selectById(1);
    }

    @Override
    public void saveUser(User user) {
        User user1 = userDAO.selectById(user.getId());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        userDAO.updateById(user1);
    }
}
