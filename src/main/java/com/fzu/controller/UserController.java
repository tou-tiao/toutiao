package com.fzu.controller;

import com.fzu.pojo.User;
import com.fzu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 用户登录
    @RequestMapping(value = "/auth/identity", method = RequestMethod.POST)
    String signin(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap map, HttpServletRequest request){
       User user = userRepository.findByEmail(email);
       if (null == user){
           return "user-login";
       }
       String nick_name = user.getNickName();
       map.addAttribute("nick_name", nick_name);
       return "index";
    }

    // 用户收藏
    @RequestMapping(value = "/favorites", method = RequestMethod.GET)
    String favorites(){
        return "";
    }
    // 用户分享
    @RequestMapping(value = "/u/{id}", method = RequestMethod.GET)
    String contribute(){
        return "";
    }

    // 用户独家号
    @RequestMapping(value = "/u/{id}/subjects", method = RequestMethod.GET)
    String subjects(){
        return "";
    }

    // 用户关注
    @RequestMapping(value = "/u/{id}/following", method = RequestMethod.GET)
    String following(){
        return "";
    }

    // 用户粉丝
    @RequestMapping(value = "/u/{id}/followers", method = RequestMethod.GET)
    String followers(){
        return "";
    }


    // 用户货币
    @RequestMapping(value = "/account/coin", method = RequestMethod.GET)
    String coin(){
        return "";
    }

    // 用户设置
    @RequestMapping(value = "/account/settings", method = RequestMethod.GET)
    String settings(){
        return "settings";
    }

    // 我的订阅
    @RequestMapping(value = "/account/subscriptions", method = RequestMethod.GET)
    String subscriptions(){// 未登录重定向
        return "";
    }
}
