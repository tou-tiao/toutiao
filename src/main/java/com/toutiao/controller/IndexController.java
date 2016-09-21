package com.toutiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public ModelAndView homePage(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("index-no-login");
    }
    @RequestMapping(value = "/explore")
    public ModelAndView explore(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("explore-no-login");
    }
    @RequestMapping(value = "/lastest")
    public ModelAndView latest(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("lastest-no-login");
    }
    @RequestMapping(value = "/search")
    public ModelAndView search(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("no-login-search");
    }
    @RequestMapping(value = "/signin")
    public ModelAndView signin(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("user-login");
    }

}
