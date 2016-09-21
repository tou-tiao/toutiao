package com.toutiao.controller;

import com.toutiao.pojo.User;
import com.toutiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 标注成为一个 Spring MVC 的 Controller */
@Controller
@RequestMapping(value = "/auth")
public class UserController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/identity", method = RequestMethod.POST)
    public ModelAndView homePage(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
//        boolean hasUser = userService.hasUser(email);
//        if(!hasUser){
//            return new ModelAndView("login");
//        }
        User user = userService.signin(email, password);
        if (null == user.getEmail()){
            return new ModelAndView("failed");
        }

        return new ModelAndView("settings");
    }

}
