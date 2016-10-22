package com.fzu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/favorites")
public class FavoriteController {

    //订阅公众号
    @RequestMapping(value = "/exclusive/{eid}")
    String subject(){ 
        return "";
    }

    // 收藏文章
    @RequestMapping(value = "/post/{aid}")
    String favorites(){
        return "";
    }
}
