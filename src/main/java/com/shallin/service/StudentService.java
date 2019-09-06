package com.shallin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.shallin.entity.Student;

/**
 * 学生service
 * @author shallin
 *
 */
@Service
public interface StudentService {
    Student findByUserName(String username);
    int add(Student student);
    int edit(Student student);
    int delete(String ids);
    List<Student> findList(Map<String, Object> queryMap);
    List<Student> findAll();
    int getTotal(Map<String, Object> queryMap);
}
