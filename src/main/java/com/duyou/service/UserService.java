package com.duyou.service;

import com.duyou.entity.User;

import java.util.List;

public interface UserService {
    //添加用户
    void addUser(User user);
    //根据Name查询
    List<User> findByName(String name);
}
