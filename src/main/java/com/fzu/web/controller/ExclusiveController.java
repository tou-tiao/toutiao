package com.fzu.web.controller;

import com.fzu.pojo.Exclusive;
import com.fzu.repository.ExclusiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/e")
public class ExclusiveController {

    @Autowired
    private ExclusiveRepository exclusiveRepository;

    // 申请独家号
    @RequestMapping(value = "/create")
    String createSubjects(){
        return "exclusive";
    }

    // 调到独家号页面
    @RequestMapping(value = "/e{id}")
    String exclusives(@PathVariable("id") Long exclusiveId, Model model){
        Exclusive exclusive = exclusiveRepository.findOne(exclusiveId);
        model.addAttribute("exclusive", exclusive);
        return "exclusive";
    }
    
    // 修改独家号
    @RequestMapping(value = "/e{id}/edit")
    String editSubjects(){
        return "";
    }
}
