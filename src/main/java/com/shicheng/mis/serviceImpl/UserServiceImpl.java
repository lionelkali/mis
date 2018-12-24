package com.shicheng.mis.serviceImpl;

import com.shicheng.mis.entity.User;
import com.shicheng.mis.mapper.UserMapper;
import com.shicheng.mis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }
}
