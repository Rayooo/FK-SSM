package org.fkit.controller;

import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;

/**
 * Created by Ray on 2017/3/10.
 */
@Controller
public class UserController {
    @RequestMapping(value = "/login")
    public ModelAndView login(String loginName, String password, ModelAndView mv, HttpSession session){
        //模拟数据库根据登陆名和密码查找用户，判断用户登陆
        if("fkit".equals(loginName) && "123".equals(password)){
            //模拟创建用户
            User user = new User();
            user.setLoginName(loginName);
            user.setPassword(password);
            user.setUserName("管理员");

            //登陆成功，将user对象设置到HttpSession作用域
            session.setAttribute("user",user);

            //转发到main请求
            mv.setViewName("redirect:main");
        }
        else{
            mv.addObject("message","登陆名或密码错误，请重新输入");
            mv.setViewName("loginForm");

        }
        return mv;
    }



}
