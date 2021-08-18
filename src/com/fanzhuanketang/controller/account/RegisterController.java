package com.fanzhuanketang.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fanzhuanketang.po.Student;
import com.fanzhuanketang.po.Teacher;
import com.fanzhuanketang.service.RegisterService;

import java.sql.Date;

@Controller
@RequestMapping("/LoginRegister")
public class RegisterController{
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping("/registerpage.action")
	public String registerPage(int usertype) {
		switch (usertype) {
		case 0:
			return "LoginRegister/stuRegister";
		case 1:
			return "LoginRegister/teaRegister";
		default:
			return "LoginRegister/stuRegister";
		}
	}
	
	@RequestMapping("/studentregister.action")
    public String registerStudent(String id, String password,
    		String name, boolean sex, Date birthday, String school, String departmet, String clas, String phonenum,
    		Model model) {
        if (registerService.registerStudent(new Student(id, name, sex, birthday, phonenum, school, departmet, clas, password))) {
        	return "forward:/LoginRegister/studentlogin.action";
        } else {
            return "redirect:/registerpage.action?usertype=0";
        }
    }
	
	@RequestMapping("/teacherregister.action")
    public String registerTeacher(String id, String password, 
    		String name, boolean sex, Date birthday, String school, String pro, String phonenum,
    		Model model) {
        if (registerService.registerTeacher(new Teacher(id, name, sex, birthday, phonenum, school, pro, password))) {
            return "forward:/LoginRegister/teacherlogin.action";
        } else {
            return "redirect:/registerpage.action?usertype=1";
        }
    }

}
