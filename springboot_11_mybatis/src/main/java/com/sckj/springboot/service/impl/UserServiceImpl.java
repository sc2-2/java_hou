package com.sckj.springboot.service.impl;

import com.sckj.springboot.dao.UserMapper;
import com.sckj.springboot.entity.User;
import com.sckj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Long id) {
       return userMapper.getUser(id);
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }
}
