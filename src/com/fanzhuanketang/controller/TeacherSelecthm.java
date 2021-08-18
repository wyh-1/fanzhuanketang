package com.fanzhuanketang.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fanzhuanketang.po.Homework;
import com.fanzhuanketang.po.HomeworkAnswer;
import com.fanzhuanketang.po.Student;
import com.fanzhuanketang.service.*;
@Controller
public class TeacherSelecthm{
	@Autowired
	private Teacher tea;
	@RequestMapping("/selecthma.action")
	public String selecthmByid(String studentid,String homeworkid, Model model){
		//Teacher tea=null;
		Student stu=tea.select1(studentid);
		HomeworkAnswer hmanswer=tea.select2(homeworkid);
		Homework hw=tea.select3(homeworkid);
		model.addAttribute("stu",stu);
		model.addAttribute("hmanswer", hmanswer);
		model.addAttribute("hw", hw);
		return "/jsp/selecthma";
	}
}
