package org.fkit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fkit.domain.Book;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ray on 2017/3/5.
 */
@Controller
@RequestMapping("/json")
public class BookController {
    private static final Log logger = LogFactory.getLog(BookController.class);

//    @RequestMapping(value = "/testRequestBody")
//    public void setJson(@RequestBody Book book, HttpServletResponse response) throws Exception{
//
//        //ObjectMapper类是Jackson库的主要类，它提供一些功能将java对象转换成对应的JSON格式数据
//        ObjectMapper mapper = new ObjectMapper();
//
//        logger.info(mapper.writeValueAsString(book));
//        book.setAuthor("Ray");
//        response.setContentType("text/html;charset=UTF-8");
//
//        //将book对象转换成json写出到客户端
//        response.getWriter().println(mapper.writeValueAsString(book));
//    }

    @RequestMapping(value="/testRequestBody", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setJson(@RequestBody Book book,
                        HttpServletResponse response) throws Exception{
        // ObjectMapper类是Jackson库的主要类。它提供一些功能将Java对象转换成对应的JSON格式的数据
        ObjectMapper mapper = new ObjectMapper();
        // 将book对象转换成json输出
        logger.info(mapper.writeValueAsString(book) );
        book.setAuthor("肖文吉");
        response.setContentType("text/html;charset=UTF-8");
        // 将book对象转换成json写出到客户端
        response.getWriter().println(mapper.writeValueAsString(book));
    }

}
