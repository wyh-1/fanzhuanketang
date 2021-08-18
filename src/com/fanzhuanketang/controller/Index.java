package com.fanzhuanketang.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
	
	@RequestMapping("/index.action")
	public String index(HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		Integer usertype = (Integer)session.getAttribute("usertype");
		if (userid == null || usertype == null) {
		    return "LoginRegister/stuLogin";
		} else {
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
		
	}
	
}
