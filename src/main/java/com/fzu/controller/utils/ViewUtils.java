package com.fzu.controller.utils;

import com.fzu.pojo.User;
import com.fzu.repository.UserRepository;
import com.fzu.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewUtils {

    @Autowired
    private UserRepository userRepository;

    public User getCurrentUser() {
        return userRepository.findByEmail(SecurityUtils.getCurrentUserEmail());
    }

}
