package com.zking.ssm.controller;


import com.zking.ssm.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;

@Controller
public class HelloController {

    @ModelAttribute
    public void init(Model model){
        String[] bookType = {"神话","小说","爱情"};

        model.addAttribute("bookType",bookType);
        System.out.println("init...");
    }



    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name, Book book, @RequestParam Map map, HttpServletRequest request){
        System.out.println("hello world!!!");
        System.out.println("name="+name);
        System.out.println("book="+book);
        System.out.println("map="+map);
        System.out.println("request="+request);
        return "index";//逻辑视图名
    }

    @RequestMapping(value = "/hello2")
    public ModelAndView hello2(@RequestParam String name, Book book, @RequestParam Map map, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("book1", book);
        return modelAndView;
    }


    @RequestMapping(value = "/hello3")
    public String hello3(@RequestParam String name, Book book, @RequestParam Map map, HttpServletRequest request, Model model) {
        model.addAttribute("name",name);
        return "index";
    }

    @RequestMapping(value = "/hello4")
    public String hello4(@RequestParam String name, Book book, @RequestParam Map map, HttpServletRequest request, Model model) {
        request.setAttribute("map",map);
//        return "index";
        return "redirect:toIndex";
    }


    @RequestMapping(value = "/toIndex")
    public String toIndex() {
        System.out.println("toIndex....");
        return "index";
    }

    @RequestMapping(value = "/home/home.html")
    public String toHome() {
        System.out.println("toHome....");
        return "login";
    }

    @RequestMapping(value = "/change")
    public String change(@RequestParam String locale, HttpSession session) {
        if(locale.equals("zh")){
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.CHINA);
        }else{
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.US);
        }
        return "index";
    }
}
