package com.fzu.web.controller;

import com.fzu.pojo.Article;
import com.fzu.pojo.Collect;
import com.fzu.pojo.Exclusive;
import com.fzu.pojo.Subscribe;
import com.fzu.repository.*;
import com.fzu.service.UserService;
import com.fzu.tools.Constant;
import com.fzu.tools.IdGenerate;
import com.fzu.web.controller.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.fzu.tools.EncryptUtils.md5;

@Controller
@RequestMapping(value = "u{id}/")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExclusiveRepository exclusiveRepository;
    @Autowired
    private SubscribeRepository subscribeRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CollectRepository collectRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ViewUtils viewUtils;

    // 用户的收藏
    @RequestMapping(value = "favorites", method = RequestMethod.GET)
    String favorites(Model model) {
        List<Article> articleList = new ArrayList<>();
        List<Collect> collectList = collectRepository.findByUserId(viewUtils.getCurrentUser().getId());
        if (null != collectList){
            articleList.addAll(collectList.stream().map(Collect::getArticle).collect(Collectors.toList()));
        }
        model.addAttribute("articleList", articleList);
        return "myCollect";
    }

    // 跳到我的独家号
    @RequestMapping(value = "/exclusives")
    String exclusives(@PathVariable("id") Long userId, Model model){
        List<Exclusive> exclusives  = exclusiveRepository.findByOwnUserId(userId);
        model.addAttribute("exclusives", exclusives);
        return "myExclusive";
    }

    // 我的主页
    @RequestMapping(value = "home")
    String home() {
        return "home";
    }

    // 跳转到用户信息设置界面
    @RequestMapping(value = "settings")
    String settings() {
        return "settings";
    }

    // 用户信息保存处理
    @RequestMapping(value = "settings", method = RequestMethod.POST)
    String userInfo(HttpServletRequest request,
                    @RequestParam("email") String email,
                    @RequestParam("nickName") String nickName,
                    @RequestParam("git") String git,
                    @RequestParam("homePage") String homePage,
                    @RequestParam("bio") String bio,
                    @RequestParam("file") MultipartFile file) {
        if(!file.isEmpty()){
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).toLowerCase();
            try {
                boolean deleteStatus = userService.deleteAvatar();
                if(deleteStatus){
                    final IdGenerate idGenerate = new IdGenerate(0, 0);
                    String imgName = idGenerate.nextId() + suffix;
                    file.transferTo(new File(Constant.BASE_UPLOAD_PATH + imgName));
                    userService.updateAvatar(imgName);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String url = "/u" + viewUtils.getCurrentUser().getId() + "/home";
        return "redirect:" + url;
    }

    // 我的订阅
    @RequestMapping(value = "subscriptions", method = RequestMethod.GET)
    String subscriptions(Model model) {
        List<Article> articleList = null;
        List<Subscribe> subscribeList = subscribeRepository.findByUserId(viewUtils.getCurrentUser().getId());
        if(null != subscribeList){
            List<Long> exclusiveIds = subscribeList.stream().map(subscribe -> subscribe.getExclusive().getId()).collect(Collectors.toList());
            articleList = articleRepository.findByExclusiveIds(exclusiveIds);
        }
        model.addAttribute("articleList", articleList);
        return "subscriptions";
    }

}
