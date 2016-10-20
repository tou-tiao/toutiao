package com.fzu.controller;

import com.fzu.forms.UserForm;
import com.fzu.pojo.User;
import com.fzu.repository.UserRepository;
import com.fzu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String homePage() { // 首页
        return "index";
    }

    @RequestMapping(value = "/explore", method = RequestMethod.GET)
    public String explore() {  // 所有独家号
        return "explore";
    }

    @RequestMapping(value = "/lastest", method = RequestMethod.GET)
    public String latest() { // 最新分享文章
        return "lastest";
    }

    @RequestMapping(value = "/signin")
    public String signin() { //登录界面
        return "signin";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@Valid UserForm userForm) {
        Integer status = userService.signupStatus(userForm.getEmail(), userForm.getNickName(), userForm.getPassword());
        if (status == 0) {        // 邮箱已经存在
            return "signin";
        }
        if (status == 1) {        // 昵称已存在
            return "signin";
        }

        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setNickName(userForm.getNickName());
        user.setPassword(userForm.getPassword());

        userRepository.save(user);
        return "signin";
    }

    // 跳转到分享文章的页面
    @RequestMapping(value = "/share")
    String contribute(){
        return "share";
    }

}
