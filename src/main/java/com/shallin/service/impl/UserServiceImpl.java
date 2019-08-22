package com.shallin.service.impl;

import com.shallin.dao.UserMapper;
import com.shallin.entity.User;
import com.shallin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
private  UserMapper userMapper;
    @Override
    public User findByUserName(String username) {
return  userMapper.findByUserName(username);
    }
}
