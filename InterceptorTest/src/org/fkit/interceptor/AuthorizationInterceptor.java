package org.fkit.interceptor;

import org.fkit.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ray on 2017/3/10.
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

    //不拦截"/loginForm"和"/login"请求
    private static final String[] IGNORE_URI = {"/loginForm","/login"};

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("AuthorizationInterceptor preHandle -->");

        //flag变量用于判断用户是否登陆，默认false
        boolean flag = false;
        //获取请求的路径进行判断
        String servletPath = httpServletRequest.getServletPath();
        //判断请求是否要拦截
        for(String s : IGNORE_URI){
            if(servletPath.contains(s)){
                flag = true;
                break;
            }
        }

        //拦截请求
        if(!flag){
            //获取session中的用户
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            //判断用户是否登陆
            if(user == null){
                System.out.println("AuthorizationInterceptor 拦截请求");
                httpServletRequest.setAttribute("message","请先登陆在访问网站");
                httpServletRequest.getRequestDispatcher("loginForm.jsp").forward(httpServletRequest,httpServletResponse);
            }else{
                System.out.println("AuthorizationInterceptor 放行请求");
                flag = true;
            }
        }

        return flag;
    }


    //该方法将在Controller的方法调用之后执行，方法中可以对ModelAndView进行操作
    //该方法也只能在当前Interceptor的preHandle方法返回值为true时才会执行
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("AuthorizationInterceptor postHandle --> ");
    }


    //该方法将整个请求完成之后执行，主要作用是用于清理资源
    //该方法也只能在当前Interceptor的preHandle方法返回值为true时才会执行
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("AuthorizationInterceptor afterCompletion -->");
    }
}
