package com.shallin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.shallin.entity.Grade;

/**
 *年级service
 * @author shallin
 *
 */
@Service
public interface GradeService {
	int add(Grade grade);
	int edit(Grade grade);
	int delete(String ids);
	List<Grade> findList(Map<String, Object> queryMap);
	List<Grade> findAll();
	int getTotal(Map<String, Object> queryMap);
}
