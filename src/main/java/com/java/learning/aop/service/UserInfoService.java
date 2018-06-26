package com.java.learning.aop.service;

import org.springframework.stereotype.Component;

/**
 * Description: 用户服务
 * User:Lee
 * Date:2018/6/26
 */
@Component
public class UserInfoService {

    public void add(){
        System.out.println("UserInfoService add user info");
    }

    public boolean delete(){
        System.out.println("UserInfoService delete user info");
        return true;
    }

}
