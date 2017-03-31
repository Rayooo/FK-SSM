package org.fkit.controller;

import org.fkit.domain.User;
import org.fkit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

/**
 * Created by Ray on 2017/3/19.
 */
@Controller
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(value = "/login")
    public ModelAndView login(String loginname, String password, ModelAndView mv, HttpSession session){
        User user = userService.login(loginname,password);
        if(user != null){
            session.setAttribute("user",user);
            mv.setView(new RedirectView("/main"));
        }else{
            mv.addObject("message","登陆名或密码错误");
            mv.setViewName("loginForm");
        }
        return mv;
    }


}
