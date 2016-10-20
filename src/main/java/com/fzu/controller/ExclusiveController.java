package com.fzu.controller;

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
        return "user-subs";
    }

    // 调到独家号页面
    @RequestMapping(value = "/{eid}")
    String exclusives(@PathVariable("eid") Long exclusiveId, Model model){
        Exclusive exclusive = exclusiveRepository.findOne(exclusiveId);
        model.addAttribute("exclusive", exclusive);
        return "exclusive";
    }
    
    // 修改独家号
    @RequestMapping(value = "/{eid}/edit")
    String editSubjects(){
        return "user-subs";
    }
}
