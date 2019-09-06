package com.shallin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shallin.dao.StudentMapper;
import com.shallin.entity.Student;
import com.shallin.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    public int add(Student student) {
        return studentMapper.add(student);
    }

    public int edit(Student student) {
        return studentMapper.edit(student);
    }

    public int delete(String ids) {
        return studentMapper.delete(ids);
    }

    public List<Student> findList(Map<String, Object> queryMap) {
        return studentMapper.findList(queryMap);
    }

    public List<Student> findAll() {
        return studentMapper.findAll();
    }
    public int getTotal(Map<String, Object> queryMap) {
        return studentMapper.getTotal(queryMap);
    }

    public Student findByUserName(String username) {
        return studentMapper.findByUserName(username);
    }

}
