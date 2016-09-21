package com.toutiao.service;

import com.toutiao.dao.UserDao;
import com.toutiao.pojo.User;
import com.toutiao.service.impl.UserServiceImpl;
import com.toutiao.tools.EncryptUtils;
import com.toutiao.tools.StringKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* 将 UserService 注解为一个服务层的Bean */
@Service
public class UserService implements UserServiceImpl{
    @Autowired
    private UserDao userDao;

    public User signin(String email, String passWord) {
        if(StringKit.isBlank(email) || StringKit.isBlank(passWord)){
            return null;
        }
        String pwd = EncryptUtils.md5(email + passWord);
        User user = userDao.getUser(email, pwd);
        return user;
    }

//    public boolean hasUser(String email) {
//        return userDao.hasUser(email);
//    }
}
