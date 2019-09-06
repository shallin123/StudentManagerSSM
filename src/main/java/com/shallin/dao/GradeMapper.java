package com.shallin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shallin.entity.Grade;

/**
 * 年级dao
 * @author shallin
 *
 */
@Repository
public interface GradeMapper {
	int add(Grade grade);
	int edit(Grade grade);
	int delete(String ids);
	List<Grade> findList(Map<String, Object> queryMap);
	List<Grade> findAll();
	int getTotal(Map<String, Object> queryMap);
}
