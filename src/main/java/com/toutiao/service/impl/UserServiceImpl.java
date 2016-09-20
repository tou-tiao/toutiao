package com.toutiao.service.impl;

import com.toutiao.dao.UserMapper;
import com.toutiao.pojo.User;
import com.toutiao.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    public User getUserById(int userId) {
        // TODO Auto-generated method stub
        return this.userMapper.selectByPrimaryKey(userId);
    }

}