package com.shicheng.mis.controller;

import com.shicheng.mis.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //登录处理
    @RequestMapping("/login")
    public String login(String username, String password, Model model){

        System.out.println(username);

        //1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);

        //3.执行登录方法

        try {
            subject.login(usernamePasswordToken);
            return "/test";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名不存在");
            //return "redirect:/toLogin";
            return "login";
           // e.printStackTrace();

        } catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }

        //return "";
    }




    @RequestMapping("/test")
    public Object test(){

        return "/test";
    }

    @RequestMapping("/add")
    public Object add(){

        return "/user/add";
    }

    @RequestMapping("/update")
    public Object update(){

        return "/user/update";
    }

    @RequestMapping("/toLogin")
    public Object toLogin(){

        return "/login";
    }


}
