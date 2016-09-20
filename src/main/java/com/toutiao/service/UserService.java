package com.toutiao.service;

import com.toutiao.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* 将 UserService 注解为一个服务层的Bean */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    public int volidLogin(String userName, String password){
        int userId = userDao.volidLogin(userName,password);
        return userId ;
    }
    /*public String getMrchName(String userName, String password){
        String mrchName = userDao.getMrchName(userName,password);
        return mrchName ;
    }*/

}
