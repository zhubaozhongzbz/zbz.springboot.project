package com.zbz.boot.format.service;

import com.zbz.boot.format.bean.User;
import com.zbz.boot.format.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getUser(Integer id){
        return  userMapper.getUser(id);
    }
    public User getByName(String name){
        return userMapper.getByUserName(name);
    }
}
