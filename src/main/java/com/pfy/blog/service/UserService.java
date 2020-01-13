package com.pfy.blog.service;

import com.pfy.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;



@Repository
public interface UserService {
     User selectUser(String username);
     User getUser();
}
