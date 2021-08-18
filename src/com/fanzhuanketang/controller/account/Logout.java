package com.fanzhuanketang.controller.account;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/LoginRegister")
public class Logout {

	@RequestMapping("/logout.action")
    public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index.action";
//        String userid = (String)session.getAttribute("userid");
//        Integer usertype = (Integer)session.getAttribute("usertype");
//        if (userid == null || usertype == null) {
//            return "redirect:stuLogin.jsp";
//        } else {
//            session.setAttribute("userid", null);
//            session.setAttribute("usertype", null);
//            switch (usertype) {
//                case 0:
//                	return "redirect:stuLogin.jsp";
//                case 1:
//                	return "redirect:teaLogin.jsp";
//                case 2:
//                	return "redirect:managerLogin.jsp";
//                default:
//                	return "redirect:stuLogin.jsp";
//            }
//        }
    }
}
