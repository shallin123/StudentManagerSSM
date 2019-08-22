package com.shallin.service;

import com.shallin.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User findByUserName(String name);
}
