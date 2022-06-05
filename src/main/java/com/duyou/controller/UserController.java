package com.duyou.controller;

import com.duyou.entity.Book;
import com.duyou.entity.User;
import com.duyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("user")
@CrossOrigin //跨域
public class UserController {
    @Autowired
    private UserService userService;

    //登录
    @PostMapping("signin")
    public Map<String,Object> signin(@RequestBody User user){
        Map<String,Object> map=new HashMap<>();
        List<User> users = userService.findByName(user.getName());
        if (users.isEmpty()){
            map.put("success",false);
            map.put("message","User is not exists.");
        } else if (!Objects.equals(users.get(0).getPassword(), user.getPassword())) {
            map.put("success",false);
            map.put("message","Password error.");
        } else {
            map.put("success",true);
        }
        return map;
    }
    //新增用户
    @PostMapping("signup")
    public Map<String,Object> signup(@RequestBody User user){
        Map<String,Object> map=new HashMap<>();
        try {
            userService.addUser(user);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message","Username already exists.");
        }
        return map;
    }
}
