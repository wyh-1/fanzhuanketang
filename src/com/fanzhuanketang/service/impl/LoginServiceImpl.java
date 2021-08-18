package com.fanzhuanketang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fanzhuanketang.dao.AdminDAO;
import com.fanzhuanketang.dao.StudentDAO;
import com.fanzhuanketang.dao.TeacherDAO;
import com.fanzhuanketang.po.Admin;
import com.fanzhuanketang.po.Student;
import com.fanzhuanketang.po.Teacher;
import com.fanzhuanketang.service.LoginService;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private TeacherDAO teacherDAO;
	
    @Override
    public boolean loginAdmin(String username, String password) {
        Admin admins = adminDAO.selectByAccount(username);
        return admins != null && admins.getPassword().equals(password);
    }
    
    @Override
    public boolean loginStudent(String username, String password) {
        Student student = studentDAO.selectByID(username);
        return student != null && student.getPassword().equals(password);
    }
    
    @Override
    public boolean loginTeacher(String username, String password) {
        Teacher teachers = teacherDAO.selectByID(username);
        return teachers != null && teachers.getPassword().equals(password);
    }
}
