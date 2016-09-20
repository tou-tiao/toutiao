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
        User user = AR.find("select * from t_user where login_name = ? and pass_word = ? and status in (0, 1)",
                loginName, pwd).first(User.class);
        if(null == user){
            user = AR.find("select * from t_user where email = ? and pass_word = ? and status in (0, 1)",
                    loginName, pwd).first(User.class);
        }
        return user;
    }

    public boolean hasUser(String login_name) {
        return false;
    }
}
