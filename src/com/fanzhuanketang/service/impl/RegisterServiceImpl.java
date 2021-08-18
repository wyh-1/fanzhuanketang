package com.fanzhuanketang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fanzhuanketang.dao.StudentDAO;
import com.fanzhuanketang.dao.TeacherDAO;
import com.fanzhuanketang.po.Student;
import com.fanzhuanketang.po.Teacher;
import com.fanzhuanketang.service.RegisterService;

@Service("registerService")
@Transactional
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private TeacherDAO teacherDAO;
	
	@Override
    public boolean registerStudent(Student student) {
        return studentDAO.insert(student) > 0;
    }
    
	@Override
    public boolean registerTeacher(Teacher teacher) {
        return teacherDAO.insert(teacher) > 0;
    }
}
