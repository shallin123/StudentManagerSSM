package com.shallin.dao;

import com.shallin.entity.User;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    public User findByUserName(String username);
    public int add(User user);
    public List<User> findList(Map<String,Object> queryMap);
}