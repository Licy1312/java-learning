package com.java.learning.aop;

import com.java.learning.aop.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 * User:Lee
 * Date:2018/6/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-app.xml")
public class AppTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void testAspect(){
        userInfoService.add();
    }
}
