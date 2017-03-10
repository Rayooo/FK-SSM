package org.fkit.controller;

import org.fkit.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray on 2017/3/10.
 */
@Controller
public class BookController {
    @RequestMapping(value = "/main")
    public String main(Model model){
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("疯狂java讲义","李刚",72.2));
        bookList.add(new Book("Java EE","李刚",23));
        bookList.add(new Book("Adnroid讲义","李刚",55));

        model.addAttribute("bookList",bookList);
        return "main";

    }

}
