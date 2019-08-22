package com.shallin.dao;

import com.shallin.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public User findByUserName(String username);
}