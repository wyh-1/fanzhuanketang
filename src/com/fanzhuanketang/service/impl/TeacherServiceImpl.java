package com.fanzhuanketang.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fanzhuanketang.dao.TeacherDAO;
import com.fanzhuanketang.po.Homework;
import com.fanzhuanketang.po.HomeworkAnswer;
import com.fanzhuanketang.po.Student;
import com.fanzhuanketang.service.Teacher;
@Service("Teacher")
@Transactional
public class TeacherServiceImpl implements Teacher{
	private TeacherDAO teacherdao;
	@Override
	public Homework selectByID(String id) {
		// TODO 自动生成的方法存根
		return teacherdao.selectByID(id);
	}

	@Override
	public void add(String userid) {
		// TODO 自动生成的方法存根
		teacherdao.add(userid);
	}
	@Override
	public HomeworkAnswer select2(String homeworkid) {
		// TODO 自动生成的方法存根
		return teacherdao.select2(homeworkid);
		
	}

	@Override
	public Student select1(String studentid) {
		// TODO 自动生成的方法存根
		return teacherdao.select1(studentid);
	}

	@Override
	public Homework select3(String homeworkid) {
		// TODO 自动生成的方法存根
		return teacherdao.select3(homeworkid);
	}

}
