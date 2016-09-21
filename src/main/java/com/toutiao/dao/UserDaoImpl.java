package com.toutiao.dao;


import com.toutiao.pojo.User;

public interface UserDaoImpl {
    public User getUser(final String email, final String passWord);
//    public boolean hasUser(final String email);
}
