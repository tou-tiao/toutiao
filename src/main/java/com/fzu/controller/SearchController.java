package com.fzu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {

    // 搜索文章
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String findArticle(){ // 搜索界面
        return "search";
    }///search?utf8=✓&q=1

    // 搜索独家号
    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public String findExclusive(){ // 搜索界面
        return "search";
    }///subjects?utf8=✓&q=v
}
