package org.fkit.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fkit.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

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


}
