package com.fzu.service;

import com.fzu.Application;
import com.fzu.pojo.User;
import com.fzu.repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
@Transactional
public class LoginTest {

    @Inject
    private UserRepository userRepository;
    @Test
    private void InsertRecord(){
        User user = new User();
        user.setEmail("1034@qq.com");
        userRepository.save(user);
    }
}
