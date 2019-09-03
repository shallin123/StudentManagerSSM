package com.shallin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shallin.entity.User;

@Repository
public interface UserMapper {
    User findByUserName(String username);
    int add(User user);
    int edit(User user);
    int delete(String ids);
    List<User> findList(Map<String, Object> queryMap);
    int getTotal(Map<String, Object> queryMap);
}


