package com.shallin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shallin.dao.ClazzMapper;
import com.shallin.dao.GradeMapper;
import com.shallin.entity.Clazz;
import com.shallin.entity.Grade;
import com.shallin.service.ClazzService;
import com.shallin.service.GradeService;
@Service
public class ClazzServiceImpl implements ClazzService {

	@Autowired
	private ClazzMapper clazzMapper;
	
	@Override
	public int add(Clazz clazz) {
		return clazzMapper.add(clazz);
	}

	@Override
	public int edit(Clazz clazz) {
		return clazzMapper.edit(clazz);
	}

	@Override
	public int delete(String ids) {
		return clazzMapper.delete(ids);
	}

	@Override
	public List<Clazz> findList(Map<String, Object> queryMap) {
		return clazzMapper.findList(queryMap);
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		return clazzMapper.getTotal(queryMap);
	}

	@Override
	public List<Clazz> findAll() {
		return clazzMapper.findAll();
	}

}
