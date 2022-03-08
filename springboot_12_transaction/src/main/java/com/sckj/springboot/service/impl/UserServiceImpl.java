package com.sckj.springboot.service.impl;

import com.sckj.springboot.dao.UserMapper;
import com.sckj.springboot.entity.User;
import com.sckj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional //处理事务的注解
    public void insertUser(User user) {
        // 插入用户信息
        userMapper.insertUser(user);
        // 手动抛出异常
        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertUser2(User user) throws SQLException {
        // 插入用户信息
        userMapper.insertUser(user);
        // 手动抛出异常
        throw new SQLException();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertUser3(User user) throws SQLException {
        try {
            userMapper.insertUser(user);
            //手动抛出异常
            throw  new SQLException();
        }catch (Exception exception){
            // 异常处理逻辑
            exception.printStackTrace();
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized void insertUser4(User user) throws SQLException {
        userMapper.insertUser(user);
    }


}
