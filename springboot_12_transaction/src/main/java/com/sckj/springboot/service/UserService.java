package com.sckj.springboot.service;


import com.sckj.springboot.entity.User;

import java.sql.SQLException;

public interface UserService {

    void insertUser(User user);

    void insertUser2(User user) throws SQLException;

    void insertUser3(User user) throws SQLException;

    void insertUser4(User user) throws SQLException;
}
