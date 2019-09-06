package com.shallin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shallin.entity.Clazz;

/**
 * 班级dao
 * @author shallin
 *
 */
@Repository
public interface ClazzMapper {
    int add(Clazz clazz);
    int edit(Clazz clazz);
    int delete(String ids);
    List<Clazz> findList(Map<String, Object> queryMap);
    List<Clazz> findAll();
    int getTotal(Map<String, Object> queryMap);
}

