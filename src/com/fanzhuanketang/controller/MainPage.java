package com.fanzhuanketang.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPage {
	
	@RequestMapping("/mainPage.action")
	public String mainPage(HttpSession session) {
		Integer usertype = (Integer)session.getAttribute("usertype");
		if (usertype == null) {
          return "redirect:/index.action";
        } else {
        	switch (usertype) {
    		case 0:
    			return "stuMain";
    		case 1:
    			return "teaMain";
    		case 2:
    			return "managerMain";
    		default:
    			return "redirect:/index.action";
    		}
        }
	}
}
