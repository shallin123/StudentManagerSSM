package com.shallin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shallin.dao.UserMapper;
import com.shallin.entity.User;
import com.shallin.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Override
	public User findByUserName(String username) {
		return userMapper.findByUserName(username);
	}
	@Override
	public int add(User user) {
		return userMapper.add(user);
	}
	@Override
	public List<User> findList(Map<String,Object> queryMap) {
		return userMapper.findList(queryMap);
	}
	@Override
	public int getTotal(Map<String, Object> queryMap) {
		return userMapper.getTotal(queryMap);
	}
	@Override
	public int edit(User user) {
		return userMapper.edit(user);
	}
	@Override
	public int delete(String ids) {
		return userMapper.delete(ids);
	}

}
