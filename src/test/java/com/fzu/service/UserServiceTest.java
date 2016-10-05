package com.fzu.service;

import com.fzu.pojo.*;
import com.fzu.repository.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class UserServiceTest {
    private Logger logger =  LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserLogRepository userLogRepository;
    @Autowired
    private ExclusiveRepository exclusiveRepository;
    @Autowired
    private ArticleRepository articleRepository;

//    @Test
//    @Commit
    public void createUser() {
        User user = new User();

        user.setEmail("3@qq.com");
        user.setNickName("3");
        user.setPassword("12345678123456781234567812345678");

        userRepository.save(user);
    }

//    @Test
//    @Commit
    public void createExclusive() {
        User user = userRepository.findOne(2L);

        Exclusive exclusive = new Exclusive();
        exclusive.setPublicName(user.getNickName());
        exclusive.setUser(user);

        exclusiveRepository.save(exclusive);
    }

    public void createArticle() {

    }

    public void deleteArticle() {

    }

    public void deleteExclusive() {

    }

    public void deleteUser() {

    }
}
