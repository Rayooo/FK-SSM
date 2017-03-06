package org.fkit.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fkit.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray on 2017/3/5.
 */
@Controller
@RequestMapping("json")
public class BookController {
    private static final Log logger = LogFactory.getLog(BookController.class);

    @RequestMapping(value = "/testRequestBody")
    public void setJson(@RequestBody Book book, HttpServletResponse response) throws Exception{

        logger.info(JSONObject.toJSONString(book));
        book.setAuthor("Ray");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(JSONObject.toJSONString(book));

    }

    @RequestMapping(value = "/testRespond")
    @ResponseBody
    public Object getJson(){
        List<Book> list = new ArrayList<>();
        list.add(new Book(1,"Spring MVC","Ray"));
        list.add(new Book(2,"Java EE","Tom"));
        return list;
    }

}
