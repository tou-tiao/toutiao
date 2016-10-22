package com.fzu.web.controller;

import com.fzu.pojo.User;
import com.fzu.repository.UserRepository;
import com.fzu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;
import static com.fzu.tools.EncryptUtils.md5;

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

    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> signup(
            @RequestParam("email") String email,
            @RequestParam("nickName") String nickName,
            @RequestParam("password") String password){
        User user = userRepository.findByEmailAndNickName(email, nickName);
        Map<String, Object> map = new HashMap<>();
        if(null == user){
            User user1 = new User();
            user1.setEmail(email);
            user1.setNickName(nickName);
            user1.setPassword(md5(password));
            userRepository.save(user1);
            User user2 = userRepository.findByEmail(email);
            if (null != user2){
                map.put("msg", "注册成功");
            }else{
                map.put("msg", "注册失败");
            }
        }else{
            map.put("msg", "用户已存在");
        }
        return map;
    }

    // 跳转到分享文章的页面
    @RequestMapping(value = "/share")
    String contribute(){
        return "share";
    }

}
