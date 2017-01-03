package com.fzu.web.controller;

import com.fzu.pojo.Exclusive;
import com.fzu.pojo.Subscribe;
import com.fzu.pojo.User;
import com.fzu.repository.ExclusiveRepository;
import com.fzu.repository.SubscribeRepository;
import com.fzu.service.CountingService;
import com.fzu.web.controller.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/e")
public class ExclusiveController {

    @Autowired
    private ExclusiveRepository exclusiveRepository;
    @Autowired
    private ViewUtils viewUtils;
    @Autowired
    private CountingService countingService;
    @Autowired
    private SubscribeRepository subscribeRepository;

    // 申请独家号界面
        @RequestMapping(value = "/create")
        String applyExclusive(){
            return "applyExclusive";
        }

    // 申请独家号
        @RequestMapping(value = "/create", method = RequestMethod.POST)
        public 	@ResponseBody Map<String, Object> createSubjects(
                @RequestParam("exclusiveName") String exclusiveName){
            Exclusive exclusive = exclusiveRepository.findByPublicName(exclusiveName);
            Map<String, Object> map = new HashMap<>();
            if(null == exclusive){
                Exclusive exclusive1 = new Exclusive();
                User user = viewUtils.getCurrentUser();
                exclusive1.setPublicName(exclusiveName);
                exclusive1.setUser(user);
                exclusiveRepository.save(exclusive1);
                Exclusive exclusive2 = exclusiveRepository.findByPublicName(exclusiveName);
                if (null != exclusive2){
                    map.put("msg", "申请成功");
                    map.put("exclusive", exclusive2);
                }else{
                    map.put("msg", "申请失败");
                }
            }else{
                map.put("msg", "用户已存在");
            }
            return map;
        }

    // 跳到独家号页面
        @RequestMapping(value = "/e{id}")
        String exclusives(@PathVariable("id") Long exclusiveId, Model model){
            Exclusive exclusive = exclusiveRepository.findOne(exclusiveId);
            Long userId = viewUtils.getCurrentUser().getId();
            Subscribe subscribe = subscribeRepository.findByExclusiveIdAndUserId(exclusiveId, userId);
            if(null != subscribe){
                model.addAttribute("isSub", true);
            }else{
                model.addAttribute("isSub", false);
            }
            model.addAttribute("exclusive", exclusive);
            return "exclusive";
        }

    // 修改独家号
        @RequestMapping(value = "/e{id}/edit")
        String editSubjects(){
            return "";
        }
    }
