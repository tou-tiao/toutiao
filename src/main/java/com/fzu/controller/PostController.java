package com.fzu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class PostController {

    //订阅公众号
    @RequestMapping(value = "/favorites/subject/{id}", method = RequestMethod.GET)
    String subject(){ // 未登录重定向
        return "";
    }

    // 分享
    @RequestMapping(value = "/contribute", method = RequestMethod.GET)
    String contribute(){ // 未登录重定向
        return "";
    }

    // 分享文章
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    String post(){
        return "";//回到用户分享/u/{id}
    }

    // 收藏文章
    @RequestMapping(value = "/favorites/post/{id}", method = RequestMethod.GET)
    String favorites(){
        return "";
    }
    // 文章预览
    @RequestMapping(value = "/posts/wk9rnr", method = RequestMethod.GET)
    String preArticle(){
        return "";
    }
    // 评论文章
    @RequestMapping(value = "/posts/{id}/comments", method = RequestMethod.POST)
    String comment(){
        return "";
    }
}
