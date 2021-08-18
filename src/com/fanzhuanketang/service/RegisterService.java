package com.fanzhuanketang.service;

import com.fanzhuanketang.po.Student;
import com.fanzhuanketang.po.Teacher;

public interface RegisterService {
	boolean registerTeacher(Teacher teacher);
	boolean registerStudent(Student student);
}
