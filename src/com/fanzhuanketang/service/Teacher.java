package com.fanzhuanketang.service;

import com.fanzhuanketang.po.Homework;
import com.fanzhuanketang.po.HomeworkAnswer;
import com.fanzhuanketang.po.Student;

public interface Teacher {
	public Homework selectByID(String id);
	public void add(String userid) ;
	//public ResultSet select(String TeacherID);
	//public HomeworkAnswer select2(String HomeworkID);
	 public Student select1(String studentid);
     public HomeworkAnswer select2(String howeworkid);
     public Homework select3(String homeworkid);
}
