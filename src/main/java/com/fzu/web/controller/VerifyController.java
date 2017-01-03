package com.fzu.web.controller;

import com.fzu.pojo.Exclusive;
import com.fzu.pojo.User;
import com.fzu.repository.ExclusiveRepository;
import com.fzu.repository.UserRepository;
import com.fzu.web.controller.utils.ViewUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

// 验证账号是否存在等等
@Controller
@RequestMapping(value = "/verify")
public class VerifyController {
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;
    @Autowired
    private ExclusiveRepository exclusiveRepository;
    @Autowired
    private ViewUtils viewUtils;

    /**
     * 通过注解 @ResponseBody 写入JSON数据到响应里.
     * @return {}
     */
	@RequestMapping(value = "/Email", method = RequestMethod.POST)
	public 	@ResponseBody Map<String, Object> verifyEmail(@RequestParam("email") String email){

        User user = userRepository.findByEmail(email);
        Map<String, Object> map = new HashMap<>();
        if(null == user){
            map.put("success", true);
            map.put("msg", "输入成功");
        }else{
            map.put("success", false);
            map.put("msg", "用户已存在");
        }
        return map;
	}

    @RequestMapping(value = "/updateEmail", method = RequestMethod.POST)
    public 	@ResponseBody Map<String, Object> verifyUpdateEmail(@RequestParam("email") String email){

        User user = userRepository.findByEmail(email);
        User currentUser = viewUtils.getCurrentUser();
        Map<String, Object> map = new HashMap<>();
        if(null == user || currentUser == user){
            map.put("success", true);
            map.put("msg", "输入成功");
        }else{
            map.put("success", false);
            map.put("msg", "用户已存在");
        }
        return map;
    }

    @RequestMapping(value = "/NickName", method = RequestMethod.POST)
    public 	@ResponseBody Map<String, Object> verifyNickName(@RequestParam("nickName") String nickName){

        User user = userRepository.findByNickName(nickName);
        Map<String, Object> map = new HashMap<>();
        if(null == user){
            map.put("success", true);
            map.put("msg", "输入成功");
        }else{
            map.put("success", false);
            map.put("msg", "用户已存在");
        }
        return map;
    }

    @RequestMapping(value = "/updateNickName", method = RequestMethod.POST)
    public 	@ResponseBody Map<String, Object> verifyUpdateNickName(@RequestParam("nickName") String nickName){

        User user = userRepository.findByNickName(nickName);
        User currentUser = viewUtils.getCurrentUser();
        Map<String, Object> map = new HashMap<>();
        if(null == user || currentUser == user){
            map.put("success", true);
            map.put("msg", "输入成功");
        }else{
            map.put("success", false);
            map.put("msg", "用户已存在");
        }
        return map;
    }

    @RequestMapping(value = "/ExclusiveName", method = RequestMethod.POST)
    public 	@ResponseBody Map<String, Object> verifyExclusiveName(@RequestParam("exclusiveName") String exclusiveName){

        Exclusive exclusive = exclusiveRepository.findByPublicName(exclusiveName);
        Map<String, Object> map = new HashMap<>();
        if(null == exclusive){
            map.put("success", true);
            map.put("msg", "输入成功");
        }else{
            map.put("success", false);
            map.put("msg", "独家号已存在");
        }
        return map;
    }
}
