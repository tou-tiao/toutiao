package com.fzu.web.controller;

import com.fzu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "u{id}/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 用户的收藏
    @RequestMapping(value = "favorites")
    String favorites() {
        return "myCollect";
    }

    // 我的主页
    @RequestMapping(value = "home")
    String home() {
        return "home";
    }

    // 跳转到用户信息设置界面
    @RequestMapping(value = "settings")
    String settings() {
        return "settings";
    }

    // 用户信息保存处理
    @RequestMapping(value = "settings", method = RequestMethod.POST)
    String userInfo() {
        return "settings";
    }

    // 我的订阅
    @RequestMapping(value = "subscriptions")
    String subscriptions() {
        return "subscriptions";
    }

}
