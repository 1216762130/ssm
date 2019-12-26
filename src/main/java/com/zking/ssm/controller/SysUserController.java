package com.zking.ssm.controller;


import com.zking.ssm.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sysUser")
public class SysUserController {


    @RequestMapping(value = "/login")
    public String login(SysUser sysUser, Model model) {
        String username = sysUser.getUsername();
        String password = sysUser.getPassword();
        String message = null;

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);


        try {
            subject.login(token);

        } catch (UnknownAccountException e) {
            e.printStackTrace();
            message = "账户错误";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            message = "密码错误";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("username:"+username);
            System.out.println("password:"+password);
            message = "账号或密码错误";
        }
        if (message == null) {
            return "index";
        } else {
            model.addAttribute("message", message);
            return "login";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }
}
