package com.fanzhuanketang.dao;

import java.util.List;

import com.fanzhuanketang.po.Student;

public interface StudentDAO {
    List<Student> selectAll();
    Student selectByID(String id);
    int insert(Student student);
    int update(Student student);
    int removeByID(String id);
}
