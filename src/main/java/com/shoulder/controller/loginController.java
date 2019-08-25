package com.shoulder.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {

    @RequestMapping(value = "/login")
    public String toIndex() {
        return "common/login";
    }

    @RequestMapping(value = "/loginValidate")
    public String loginValidate(Model model, String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("subject", subject);
            return "redirect:/common/index.do";
        } catch (AuthenticationException e) {
            model.addAttribute("error", "验证失败");
            return "redirect:/login.do";
        }
    }

    @RequestMapping(value = "/logout")
    public String toLogout(){
        return "redirect:/login.do";
    }
}
