package org.fkit.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ray on 2017/3/4.
 */

//基于注解的控制器，可以同时处理多个请求动作，并且无需实现任何接口
@Controller
public class HelloController {

    private static final Log logger = LogFactory.getLog(HelloController.class);

    @RequestMapping(value = "/hello")
    public ModelAndView hello(){
        logger.info("hello 方法被调用");

        ModelAndView mv = new ModelAndView();
        mv.addObject("Message","HelloWorld");
        mv.setViewName("/WEB-INF/content/welcome.jsp");

        return mv;
    }
}
