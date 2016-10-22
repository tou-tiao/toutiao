package com.fzu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/posts")
public class PostController {

    // 分享文章
    @RequestMapping(value = "", method = RequestMethod.POST)
    String post(){
        return "";//回到独家号的分享界面
    }

    // 跳到文章评论页面
    @RequestMapping(value = "/comments")
    void preArticle(){
    }

    // 评论文章
    @RequestMapping(value = "/{aid}/comments", method = RequestMethod.POST)
    void comment(){
    }
}
