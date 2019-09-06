package com.shallin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.shallin.entity.Clazz;
import com.shallin.entity.Grade;

/**
 * 班级service
 * @author shallin
 *
 */
@Service
public interface ClazzService {
	int add(Clazz clazz);
	int edit(Clazz clazz);
	int delete(String ids);
	List<Clazz> findList(Map<String, Object> queryMap);
	List<Clazz> findAll();
	int getTotal(Map<String, Object> queryMap);
}
