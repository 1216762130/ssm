package com.zking.ssm.controller;


import com.zking.ssm.model.Book;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.util.PageBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @ModelAttribute
    public void init(Model model) {
        String[] bookType = {"神话", "小说", "爱情"};

        model.addAttribute("bookType", bookType);
        System.out.println("init...");
        Book book = new Book();
        model.addAttribute("book", book);
    }


    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        System.out.println("toAdd");
        return "book/bookAdd";
    }

    @RequestMapping(value = "/addBook")
    public String addBook(@Validated(value = Book.ValidateGroups.Add.class) @ModelAttribute Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "book/bookAdd";
        }else{

            System.out.println("addBook");
            bookService.insert(book);
            return "index";
        }
    }

    @RequestMapping(value = "/listBook")
    public ModelAndView listBook(HttpServletRequest request) {
        PageBean pageBean = new PageBean();

        pageBean.initPageBean(request,pageBean);
        List<Book> bookList = bookService.listBookByPager(pageBean);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book/listBook");
        modelAndView.addObject("bookList",bookList);
        modelAndView.addObject("pageBean",pageBean);

        return modelAndView;
    }

    @RequestMapping(value = "/toUpload")
    public String toUpload() {
        System.out.println("toUpload...");
        return "book/upload";
    }

    @RequestMapping(value = "/listAll")
    @ResponseBody
    public List listAll(HttpServletRequest request) {
        PageBean pageBean = new PageBean();

        pageBean.initPageBean(request,pageBean);
        List<Book> bookList = bookService.listBookByPager(pageBean);

        return bookList;
    }


    @RequiresPermissions(value = "bookmanager:book:edit")
    @RequestMapping(value = "/listListMap")
    @ResponseBody
    public List listListMap() {

        List<Map> maps = bookService.listListMap();

        return maps;
    }


    @RequestMapping(value = "/listMap")
    @ResponseBody
    public Map listMap(@RequestParam Integer bookId) {

        Map map = bookService.listMap(bookId);

        return map;
    }

    @RequestMapping(value = "/listSingerBook")
    @ResponseBody
    public Book listSingerBook(@RequestParam Integer bookId) {

        Book book = bookService.listSingerBook(bookId);
        book.setCreateDate(new Date());
        return book;
    }
}
