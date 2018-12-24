package com.shicheng.mis.mapper;


import com.shicheng.mis.entity.User;

public interface UserMapper {

    public User findByName(String name);
}
