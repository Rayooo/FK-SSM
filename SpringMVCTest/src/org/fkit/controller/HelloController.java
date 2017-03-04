package org.fkit.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ray on 2017/3/4.
 */
public class HelloController implements Controller {

    private static final Log logger = LogFactory.getLog(HelloController.class);

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("handleRequest 被调用");
        ModelAndView mv = new ModelAndView();

        //这个Message要与jsp页面的Message对应
        mv.addObject("Message","HelloWorld");
        mv.setViewName("/WEB-INF/content/welcome.jsp");

        return mv;

    }
}
