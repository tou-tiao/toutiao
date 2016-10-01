package com.fzu.service;

import com.fzu.pojo.User;
import com.fzu.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;
    @Test
    public void InsertRecord(){
        User user = new User();
        user.setId(1L);
        userRepository.getOne(1L);
//        user.setEmail("1034@qq.com");
//        user.setPassword("123");
//        userRepository.save(user);


        logger.error("success");
    }
}
