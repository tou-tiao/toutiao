package com.toutiao.controller;



import com.toutiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
/* 标注成为一个 Spring MVC 的 Controller */
@Controller
@RequestMapping(value = "/user")
public class LoginController{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/main")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/login")
    public ModelAndView loginCheck(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("user-login");
    }
}
