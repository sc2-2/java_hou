package com.sckj.springboot.dao;

import com.sckj.springboot.entity.User;
import org.apache.ibatis.annotations.Insert;

public interface UserMapper {

    @Insert("insert into user(username,password) values(#{username},#{password})")
    Integer insertUser(User user);
}
