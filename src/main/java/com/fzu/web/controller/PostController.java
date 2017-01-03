package com.fzu.web.controller;

import com.fzu.service.PostService;
import com.fzu.web.controller.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import static com.fzu.tools.StringKit.isBlank;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private ViewUtils viewUtils;
    @Autowired
    private PostService postService;

    // 分享文章
    @RequestMapping(value = "", method = RequestMethod.POST)
    String post(@RequestParam("exclusive") String exclusive,
                @RequestParam("title") String title,
                @RequestParam("link") String link, RedirectAttributes model){
        /* addFlashAttribute():
         * 这个方法原理是放到session中，session在跳到页面后马上移除对象.
         */
        if (isBlank(title)){
            model.addFlashAttribute("msg", "请填写标题!");
            return "redirect:/share";
        }
        boolean isValidLink = postService.checkLink(link);
        if(!isValidLink){
            model.addFlashAttribute("msg", "不合法的链接!");
            return "redirect:/share";
        }

        // 判断是否分享成功
        boolean postStatus = postService.shareArticle(exclusive, title, link);
        if (postStatus){
            String redirectUrl = "/u"+ viewUtils.getCurrentUser().getId()+"/home";
            return "redirect:" + redirectUrl;//回到主页
        }
        else{
            model.addFlashAttribute("msg", "分享失败!");
            return "redirect:/share";
        }
    }

    // 跳到文章评论页面
    @RequestMapping(value = "/comments")
    void preArticle(){
    }

    // 评论文章
    @RequestMapping(value = "/Java8{id}/comments", method = RequestMethod.POST)
    void comment(){
    }
}
