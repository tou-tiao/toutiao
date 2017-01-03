package com.fzu.service;

import com.fzu.pojo.*;
import com.fzu.repository.ExclusiveRepository;
import com.fzu.repository.SubscribeRepository;
import com.fzu.repository.UserInfoRepository;
import com.fzu.repository.UserRepository;
import com.fzu.tools.Constant;
import com.fzu.web.controller.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
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
    @Autowired
    private SubscribeRepository subscribeRepository;
    @Autowired
    private CountingService countingService;
    @Autowired
    private ViewUtils viewUtils;

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
     * 删除用户旧头像
     * @return 删除成功返回true, 失败返回false
     */
    public boolean deleteAvatar(){
        User user = viewUtils.getCurrentUser();
        File beforeAvatar = new File(Constant.BASE_UPLOAD_PATH + user.getAvatar());
        if(beforeAvatar.exists()){
            boolean deleteStatus = beforeAvatar.delete();
            if(!deleteStatus){return false;}
        }
        return true;
    }

    /**
     * 保存用户旧头像
     * @param newAvatar 新的头像名
     */
    public void updateAvatar(String newAvatar){
        User user = viewUtils.getCurrentUser();
        user.setAvatar(newAvatar);
        userRepository.save(user);
    }

    /**
     * 订阅独家号.
     * @param exclusiveId 独家号ID
     * @param userId 用户ID
     * @return true 表示订阅成功，false 表示订阅失败
     */
    public boolean subExclusive(Long exclusiveId, Long userId){

        Exclusive exclusive = exclusiveRepository.findOne(exclusiveId);
        User user = userRepository.findOne(userId);
        Subscribe subscribe  = subscribeRepository.findByExclusiveIdAndUserId(exclusiveId, userId);
        if(null == subscribe){
            Subscribe subscribe1 = new Subscribe();
            subscribe1.setUser(user);
            subscribe1.setExclusive(exclusive);
            user.getSubscribes().add(subscribe1);
            exclusive.getSubscribes().add(subscribe1);
            subscribeRepository.save(subscribe1);
            Subscribe subscribe2 = subscribeRepository.findByExclusiveIdAndUserId(exclusiveId, userId);
            if((exclusiveId.equals(subscribe2.getExclusive().getId()))&&(userId.equals(subscribe2.getUser().getId()))){
                countingService.countExclusiveSub(exclusiveId, 'U');
                countingService.countUserSub(userId, 'U');
                return true;
            }
        }
        return false;
    }

    /**
     * 订阅独家号.
     * @param exclusiveId 独家号ID
     * @param userId 用户ID
     * @return true 表示取消订阅成功，false 表示取消订阅失败
     */
    public boolean deleteSubExclusive(Long exclusiveId, Long userId){
        Subscribe subscribe = subscribeRepository.findByExclusiveIdAndUserId(exclusiveId, userId);
        if (null != subscribe){
            subscribeRepository.delete(subscribe);
            Subscribe subscribe1 = subscribeRepository.findByExclusiveIdAndUserId(exclusiveId, userId);
            if(null == subscribe1){
                countingService.countExclusiveSub(exclusiveId, 'D');
                countingService.countUserSub(userId, 'D');
                return true;
            }
        }
        return false;
    }
}
