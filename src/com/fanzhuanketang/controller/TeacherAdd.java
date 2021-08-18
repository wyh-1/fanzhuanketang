package com.fanzhuanketang.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fanzhuanketang.dao.TeacherDAO;
import com.fanzhuanketang.po.Homework;
import com.fanzhuanketang.service.Teacher;

@Controller
@RequestMapping("/Teacher")
public class TeacherAdd{
@RequestMapping("/add.action")
public String  TeacherController(HttpSession session)
{
	String userid=(String)session.getAttribute("userid");
	Teacher tea = null;
	tea.add(userid);
	return "/jsp/add";
}
}