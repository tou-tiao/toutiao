package com.toutiao.service.impl;

import com.toutiao.pojo.User;

public interface UserService {

	User signin(String loginName, String passWord);

	boolean hasUser(String login_name);

	
}
