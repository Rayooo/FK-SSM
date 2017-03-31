package org.fkit.controller;

import org.fkit.domain.Book;
import org.fkit.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Ray on 2017/3/19.
 */
@Controller
public class BookController {

    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    @RequestMapping(value = "/main")
    public String main(Model model){
//        获取所有图书集合
        List<Book> bookList = bookService.getAll();
        model.addAttribute("bookList",bookList);
        return "main";
    }


}
