package com.fzu.web.controller;

import com.fzu.pojo.User;
import com.fzu.service.UserService;
import com.fzu.web.controller.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/favorites")
public class FavoriteController {

    @Autowired
    private ViewUtils viewUtils;
    @Autowired
    private UserService userService;

    //订阅公众号
    @RequestMapping(value = "/exclusive/e{id}")
    public @ResponseBody Map<String, Object> subject(@PathVariable("id") Long exclusiveId,
                                @RequestParam("action") Integer action,
                                Model model){
        User user = viewUtils.getCurrentUser();
        Map<String, Object> map = new HashMap<>();
        boolean isSub = false;
        if(1 == action){
            isSub = userService.subExclusive(exclusiveId, user.getId());
        }else if(-1 == action){
            isSub = userService.deleteSubExclusive(exclusiveId, user.getId());
        }
        if(isSub){
            if(1 == action) {
                model.addAttribute("isSub", true);
                map.put("status", "success");
            }
            if(-1 == action){
                model.addAttribute("isSub", false);
                map.put("status", "success");
            }
        }else{
            map.put("status", "failed");
        }

        return map;
    }

    // 收藏文章
    @RequestMapping(value = "/article/a{id}")
    String favorites(){
        return "";
    }
}
