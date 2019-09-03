package com.shallin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shallin.dao.GradeMapper;
import com.shallin.entity.Grade;
import com.shallin.service.GradeService;
@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeMapper gradeMapper;
	
	@Override
	public int add(Grade grade) {
		return gradeMapper.add(grade);
	}

	@Override
	public int edit(Grade grade) {
		return gradeMapper.edit(grade);
	}

	@Override
	public int delete(String ids) {
		return gradeMapper.delete(ids);
	}

	@Override
	public List<Grade> findList(Map<String, Object> queryMap) {
		return gradeMapper.findList(queryMap);
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		return gradeMapper.getTotal(queryMap);
	}

	@Override
	public List<Grade> findAll() {
		return gradeMapper.findAll();
	}

}
