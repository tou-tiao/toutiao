package com.fzu.web.controller;

import com.fzu.pojo.Article;
import com.fzu.pojo.Exclusive;
import com.fzu.pojo.User;
import com.fzu.repository.ArticleRepository;
import com.fzu.repository.ExclusiveRepository;
import com.fzu.repository.UserRepository;
import com.fzu.service.UserService;
import com.fzu.web.controller.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fzu.tools.EncryptUtils.md5;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ExclusiveRepository exclusiveRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ViewUtils viewUtils;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) { // 首页
        List<Article> articleList = new ArrayList<>();
        articleList = articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        return "index";
    }

    @RequestMapping(value = "/explore", method = RequestMethod.GET)
    public String explore(Model model) {  // 所有独家号
        List<Exclusive> exclusiveList = exclusiveRepository.findAll();
        model.addAttribute("exclusiveList", exclusiveList);
        return "explore";
    }

    @RequestMapping(value = "/lastest", method = RequestMethod.GET)
    public String latest(Model model) { // 最新分享文章
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        return "lastest";
    }

    @RequestMapping(value = "/signin")
    public String signin() { //登录界面
        User user = viewUtils.getCurrentUser();
        return (null == user)? "signin": "redirect:/";
    }

    @RequestMapping(value = "/register")
    public String register() {
        User user = viewUtils.getCurrentUser();
        return (null == user)? "register": "redirect:/";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> signup(
            @RequestParam("email") String email,
            @RequestParam("nickName") String nickName,
            @RequestParam("password") String password){
        User hasUser = userRepository.findByEmailAndNickName(email, nickName);
        Map<String, Object> map = new HashMap<>();
        if(null == hasUser){
            User user1 = new User();
            user1.setEmail(email);
            user1.setNickName(nickName);
            user1.setPassword(md5(password));
            user1.setAvatar("moon-220x150.png");
            userRepository.save(user1);
            User user2 = userRepository.findByEmail(email);// 判断是否注册成功
            if (null != user2){
                Exclusive exclusive = new Exclusive();
                exclusive.setPublicName(nickName);
                exclusive.setUser(user2);
                exclusiveRepository.save(exclusive);
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
    // 使用@ModelAttribute注解，获取之前addFlashAttribute添加的数据.
    String contribute(@ModelAttribute("msg") String msg, Model model){
        if(null != msg){
            model.addAttribute("msg", msg);
        }else model.addAttribute("msg", "");
        return "share";
    }

}
