package com.fanzhuanketang.controller.account;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fanzhuanketang.service.LoginService;

@Controller
@RequestMapping("/LoginRegister")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/loginpage.action")
	public String loginPage(int usertype) {
		switch (usertype) {
		case 0:
			return "LoginRegister/stuLogin";
		case 1:
			return "LoginRegister/teaLogin";
		case 2:
			return "LoginRegister/managerLogin";
		default:
			return "LoginRegister/stuLogin";
		}
	}
	
    @RequestMapping("/adminlogin.action")
    public String loginAdmin(String id, String password, Model model, HttpSession session) {
        if (this.loginService.loginAdmin(id, password)) {
            session.setAttribute("userid", id);
            session.setAttribute("usertype", 2);
            return "redirect:/mainPage.action";
        } else {
        	model.addAttribute("errorInfo", "error id or password");
            return "LoginRegister/managerLogin";
        }
    }
    
    @RequestMapping("/teacherlogin.action")
    public String loginTeacher(String id, String password, Model model, HttpSession session) {
        if (this.loginService.loginTeacher(id, password)) {
            session.setAttribute("userid", id);
            session.setAttribute("usertype", 1);
            return "redirect:/mainPage.action";
        } else {
        	model.addAttribute("errorInfo", "error id or password");
            return "LoginRegister/teaLogin";
        }
    }
    
    @RequestMapping("/studentlogin.action")
    public String loginStudent(String id, String password, Model model, HttpSession session) {
        if (this.loginService.loginStudent(id, password)) {
            session.setAttribute("userid", id);
            session.setAttribute("usertype", 0);
            return "redirect:/mainPage.action";
        } else {
        	model.addAttribute("errorInfo", "error id or password");
            return "LoginRegister/stuLogin";
        }
    }
}
