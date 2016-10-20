package com.fzu.controller;

import com.fzu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/u/{uid}")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 用户收藏
    @RequestMapping(value = "/favorites")
    String favorites() {
        return "";
    }

    // 我的主页
    @RequestMapping(value = "")
    String home() {
        return "home";
    }

    // 用户信息设置
    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    String userInfo() {
        return "settings";
    }

    // 我的订阅
    @RequestMapping(value = "/subscriptions")
    String subscriptions() {
        return "subscriptions";
    }

}
