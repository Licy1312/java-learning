package com.java.learning.stream;

import com.java.learning.lambda.Merchant;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @Author:Jinmu Date: 2018/6/7
 */
public class FunctionInterfaceTest {
    private static List<User> userList = Arrays.asList(new User("老李",50),new User("老王",70));

    public static void main(String[] args) {
        //方法1
        testFilter(new UserFilter() {
            @Override
            public boolean oldAgeJudge(User user) {
                return user.getAge()>60;
            }
        });

        //方法2,lambda表达式
        testFilter((User user)-> user.getAge()>60);
    }

    //输出userList中满足条件的用户
    public static void testFilter(UserFilter userFilter){
        for(User user:userList){
            if (userFilter.oldAgeJudge(user)){
                System.out.println(user);
            }
        }
    }
}
