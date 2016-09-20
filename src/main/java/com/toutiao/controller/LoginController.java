package com.toutiao.controller;



import com.toutiao.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 标注成为一个 Spring MVC 的 Controller */
@Controller
@RequestMapping(value = "/admin")
public class LoginController{
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/main.html")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/login.html")
    public ModelAndView loginCheck(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}

