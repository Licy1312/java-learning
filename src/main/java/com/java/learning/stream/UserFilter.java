package com.java.learning.stream;

/**
 * Description: 接口方法
 *
 * @Author:Jinmu Date: 2018/6/7
 */
@FunctionalInterface
public interface UserFilter {

    //自定义方法
    boolean oldAgeJudge(User user);

    //默认方法
    default void outUserAge(){
        System.out.println("This is a default method!");
    }

    //静态方法
    static void outUserName(){
        System.out.println("This is a static");
    }

    //父类Object类的方法
    boolean equals(Object obj);
}
