package com.fanzhuanketang.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fanzhuanketang.po.Homework;
import com.fanzhuanketang.service.*;
@Controller
public class TeacherSelect {
	@Autowired
	private Teacher tea;
	@RequestMapping("/selecthm.action")
	public String selecthmByid(String id, Model model){
		//Teacher tea=null;
		Homework hm=tea.selectByID(id);
		model.addAttribute("hm",hm);
		return "/jsp/selecthm";
	}
}
