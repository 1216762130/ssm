package com.zking.ssm.controller;


import com.zking.ssm.model.Book;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.util.PageBean;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


//@Controller
@RestController
@RequestMapping(value = "/test")
public class TestController {


    @RequestMapping(value = "/test1")
    @ResponseBody
    public String test1() {
        return "book/bookAdd";
    }

    @RequiresRoles(value = "管理员")
    @RequestMapping(value = "/test2")
    public String test2() {
        return "book/bookAdd";
    }

}
