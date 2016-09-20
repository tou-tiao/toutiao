package com.toutiao.controller;


import com.toutiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        int userId = userService.volidLogin(userName,password);
        if(!(userId > 0)){
            return new ModelAndView("login","error","用户名或密码错误。");
        }else {
            request.getSession(true).setAttribute("userId", userId);
        }
        return new ModelAndView("main");
    }
}
