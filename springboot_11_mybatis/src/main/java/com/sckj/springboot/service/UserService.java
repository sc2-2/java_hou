package com.sckj.springboot.service;

import com.sckj.springboot.entity.User;

public interface UserService {

    User getUser(Long id);

    User getUserByName(String username);
}
