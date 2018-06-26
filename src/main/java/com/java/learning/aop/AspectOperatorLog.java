package com.java.learning.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Description:定义切面类
 * User:Lee
 * Date:2018/6/26
 */
@Aspect
@Component
public class AspectOperatorLog {

    @Pointcut("within(com.java.learning.aop.service.*)")
    public void pointCut(){}

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("记录操作开始动作...");
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("记录操作完成动作...");
    }
}
