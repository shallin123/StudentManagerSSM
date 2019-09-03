package com.shallin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.shallin.entity.User;

@Service
public interface UserService {
	User findByUserName(String username);
	int add(User user);
	int edit(User user);
	int delete(String ids);
	List<User> findList(Map<String, Object> queryMap);
	int getTotal(Map<String, Object> queryMap);
}
