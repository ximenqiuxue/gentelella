package com.shoulder.controller;

import com.shoulder.model.Menu;
import com.shoulder.service.MenuService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class loginController {

    private static final Logger log = Logger.getLogger(loginController.class);

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/login")
    public String toIndex() {
        return "common/login";
    }

    @RequestMapping(value = "/loginValidate")
    public String loginValidate(Model model, String username, String password) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            Session session = subject.getSession();
            List<Menu> menus = menuService.getAll();
            session.setAttribute("subject", subject);
            session.setAttribute("menus", menus);
            return "redirect:/common/index.do";
        } catch (AuthenticationException e) {
            log.info("AuthenticationException :"+e.toString());
            model.addAttribute("error", "验证失败");
            return "redirect:/login.do";
        }
    }

    @RequestMapping(value = "/logout")
    public String toLogout(HttpServletRequest request){
        request.getSession().invalidate();
        return "common/login";
    }
}
