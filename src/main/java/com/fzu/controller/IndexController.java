package com.fzu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(){ // 首页
        return "index";
    }
    @RequestMapping(value = "/explore", method = RequestMethod.GET)
    public String explore(){  // 所有独家号
        return "explore";
    }
    @RequestMapping(value = "/lastest", method = RequestMethod.GET)
    public String latest(){ // 最新分享文章
        return "lastest";
    }
    @RequestMapping(value = "/search")
    public String search(){ // 搜索界面
        return "search";
    }
    @RequestMapping(value = "/signin")
    public String signin(){ // 搜索界面
        return "user-login";
    }
    @RequestMapping(value = "/logout")
    public String logout(){ // 搜索界面
        return "redirect:/";
    }

//    "/explore" 独家号
//    "/contribute" 分享（登录）
//    "/latest" 最新分享
//    "/u/221423/subjects" 我的独家号(登录)
//    "/account/subscriptions" 我的订阅
//    "/search"
}
