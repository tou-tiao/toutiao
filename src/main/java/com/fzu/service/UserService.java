package com.fzu.service;

import com.fzu.pojo.*;
import com.fzu.repository.ExclusiveRepository;
import com.fzu.repository.UserInfoRepository;
import com.fzu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private ExclusiveRepository exclusiveRepository;


    public boolean signin(String email, String password){
        User user = userRepository.findByEmailAndPassword(email, password);
//        User user = userRepository.findByEmailAndPassword(email, md5(password));
        return null != user;
    }

    /**
     *  获取用户信息.
     * @param userId 用户ID
     * @return  map 数组
     */
    public Map<String, Object> getUserInfo(Long userId){
        Map<String, Object> map = new HashMap<>();
        if(null != userId){
            User user = userRepository.findOne(userId);
            if(null == user){
                return map;
            }
            map.put("avatar", user.getAvatar());
            map.put("nickName", user.getNickName());
            map.put("email", user.getEmail());

            UserInfo userInfo = userInfoRepository.findByUserId(userId);
            if(null != userInfo){
                map.put("blog", userInfo.getBlog());
                map.put("github", userInfo.getGithub());
            }
        }
        return map;
    }

    /**
     * 订阅独家号.
     * @param exclusiveId 独家号ID
     * @param userId 用户ID
     * @return true 表示订阅成功，false 表示订阅失败
     */
    public boolean subExclusive(Long exclusiveId, Long userId){

//        Exclusive exclusive = exclusiveRepository.findOne(exclusiveId);
//        User user = userRepository.findOne(userId);
//        user.getSubExclusives().add(exclusive);
//        exclusive.getSubUsers().add(user);
//        exclusiveRepository.save(exclusive);
//        /** 判断订阅是否成功 **/
//        return exclusive.getSubUsers().contains(user);

        return false;
    }
}
