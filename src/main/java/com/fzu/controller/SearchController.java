package com.fzu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {

    // 搜索
    // return 的url格式为/search?utf8=✓&q=
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(){ // 搜索界面
        return "";
    }
}
