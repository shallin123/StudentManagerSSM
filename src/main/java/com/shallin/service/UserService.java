package com.shallin.service;

import com.shallin.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {

    public User findByUserName(String name);
    public  int  add(User user);
    public List<User> findList(Map<String,Object> queryMap);
}
