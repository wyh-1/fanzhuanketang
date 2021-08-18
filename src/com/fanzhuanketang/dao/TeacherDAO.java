package com.fanzhuanketang.dao;

import java.util.List;

import com.fanzhuanketang.po.Homework;
import com.fanzhuanketang.po.Teacher;
import com.fanzhuanketang.po.HomeworkAnswer;
import com.fanzhuanketang.po.Student;
public interface TeacherDAO {
    List<Teacher> selectAll();
    Homework selectByID(String id);
    public void add(String userid);
     Student select1(String studentid);
     HomeworkAnswer select2(String howeworkid);
     Homework select3(String homeworkid);
}

