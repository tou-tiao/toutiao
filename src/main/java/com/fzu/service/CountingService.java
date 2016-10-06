package com.fzu.service;

import com.fzu.pojo.Exclusive;
import com.fzu.pojo.User;
import com.fzu.repository.ExclusiveRepository;
import com.fzu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用于计算公众号的分享数与订阅数,以及用户的
 * 关注数、收藏数、粉丝数、分享数、订阅数、货币数.
 */
@Service
public class CountingService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExclusiveRepository exclusiveRepository;

    /**
     * 公众号分享数
     * @param publicId 公众号
     * @param c 'U'为分享, 'D'为取消
     */
    void countExclusiveShare(Long publicId, final char c){
        Exclusive exclusive = exclusiveRepository.findOne(publicId);
        if (null == exclusive.getShare())exclusive.setShare(0);
        Integer num = exclusive.getShare();
        switch (c){
            case 'U': ++num;
                break;
            case 'D': if (num > 0)--num;
                break;
            default:
                break;
        }
        exclusive.setShare(num);
        exclusiveRepository.save(exclusive);
    }
    /**
     * 公众号订阅数
     * @param publicId 公众号
     * @param c 'U'为订阅, 'D'为取消
     */
    void countExclusiveSub(Long publicId, final char c){
        Exclusive exclusive = exclusiveRepository.findOne(publicId);
        if (null == exclusive.getSubscriber())exclusive.setSubscriber(0);
        Integer num = exclusive.getSubscriber();
        switch (c){
            case 'U': ++num;
                break;
            case 'D': if (num > 0)--num;
                break;
            default:
                break;
        }
        exclusive.setSubscriber(num);
        exclusiveRepository.save(exclusive);
    }
    /**
     * 用户关注数
     * @param userId 用户ID
     * @param c 'U'为关注, 'D'为取消关注
     */
    void countUserAttention(Long userId, final char c){
        User user = userRepository.findOne(userId);
        if (null == user.getAttention())user.setAttention(0);
        Integer num = user.getAttention();
        switch (c){
            case 'U': ++num;
                break;
            case 'D': if (num > 0)--num;
                break;
            default:
                break;
        }
        user.setAttention(num);
        userRepository.save(user);
    }

    /**
     * 用户收藏数
     * @param userId 用户ID
     * @param c 'U'为收藏, 'D'为取消收藏
     */
    void countUserCollect(Long userId, final char c){
        User user = userRepository.findOne(userId);
        if (null == user.getCollect())user.setCollect(0);
        Integer num = user.getCollect();
        switch (c){
            case 'U': ++num;
                break;
            case 'D': if (num > 0)--num;
                break;
            default:
                break;
        }
        user.setCollect(num);
        userRepository.save(user);
    }

    /**
     * 用户粉丝数
     * @param userId 用户ID
     * @param c 'U'为粉丝, 'D'为取消
     */
    void countUserFans(Long userId, final char c){
        User user = userRepository.findOne(userId);
        if (null == user.getFans())user.setFans(0);
        Integer num = user.getFans();
        switch (c){
            case 'U': ++num;
                break;
            case 'D': if (num > 0)--num;
                break;
            default:
                break;
        }
        user.setFans(num);
        userRepository.save(user);
    }

    /**
     * 用户分享数
     * @param userId 用户ID
     * @param c 'U'为分享, 'D'为取消分享
     */
    void countUserShare(Long userId, final char c){
        User user = userRepository.findOne(userId);
        if (null == user.getShare())user.setShare(0);
        Integer num = user.getShare();
        switch (c){
            case 'U': ++num;
                break;
            case 'D': if (num > 0)--num;
                break;
            default:
                break;
        }
        user.setShare(num);
        userRepository.save(user);
    }

    /**
     * 用户订阅数
     * @param userId 用户ID
     * @param c 'U'为订阅, 'D'为取消订阅
     */
    void countUserSub(Long userId, final char c){
        User user = userRepository.findOne(userId);
        if (null == user.getSub())user.setSub(0);
        Integer num = user.getSub();
        switch (c){
            case 'U': ++num;
                break;
            case 'D': if (num > 0)--num;
                break;
            default:
                break;
        }
        user.setSub(num);
        userRepository.save(user);
    }

    /**
     * 用户货币数加1.
     * @param userId 用户ID
     */
    void countUserIo(Long userId){
        User user = userRepository.findOne(userId);
        if (null == user.getIo())user.setIo(0.0);
        Double num = user.getIo();
        num = num + 1;
        user.setIo(num);
        userRepository.save(user);
    }
}
