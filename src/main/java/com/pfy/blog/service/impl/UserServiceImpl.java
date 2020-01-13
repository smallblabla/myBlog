package com.pfy.blog.service.impl;

import com.pfy.blog.entity.User;
import com.pfy.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl {

    @Autowired
    private UserService userService;

    public User selectUser(String username) {
        User user = userService.selectUser(username);
        if (user != null) return user;
        return null;
    }

    public User getUser(){
        return userService.getUser();
    }

}
