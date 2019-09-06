package com.shallin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shallin.entity.Clazz;
import com.shallin.entity.Student;

/**
 * 学生dao
 * @author shallin
 *
 */
@Repository
public interface StudentMapper{
    Student findByUserName(String username);
    int add(Student student);
    int edit(Student student);
    int delete(String ids);
    List<Student> findList(Map<String, Object> queryMap);
    List<Student> findAll();
    int getTotal(Map<String, Object> queryMap);
}
