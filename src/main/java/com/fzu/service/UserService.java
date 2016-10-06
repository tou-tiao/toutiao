package com.fzu.service;

import com.fzu.pojo.*;
import com.fzu.repository.ExclusiveRepository;
import com.fzu.repository.UserInfoRepository;
import com.fzu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import static com.fzu.tools.EncryptUtils.md5;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private ExclusiveRepository exclusiveRepository;

    /**
     * @param email 邮箱
     * @param password 密码
     * @param nickName 昵称
     * @return 0 表示邮箱已经存在，1 表示昵称已存在，2 表示邮箱与昵称可注册
     */
    Integer signupStatus(String email, String password, String nickName){
        User user = userRepository.findByEmail(email);
        if (null != user) return 0;
        else {
            user = userRepository.findByNickName(nickName);
            if (null != user) return 1;
            else return 2;
        }
    }

    boolean signin(String email, String password){
        User user = userRepository.findByEmailAndPassword(email, password);
//        User user = userRepository.findByEmailAndPassword(email, md5(password));
        return null != user;
    }

    /**
     *  获取用户信息.
     * @param userId 用户ID
     * @return  map 数组
     */
    Map<String, Object> getUserInfo(Long userId){
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
                map.put("city", userInfo.getCity());
                map.put("github", userInfo.getGithub());
                map.put("jobs", userInfo.getJobs());
                map.put("weixin", userInfo.getWeixin());
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
    boolean subExclusive(Long exclusiveId, Long userId){

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
