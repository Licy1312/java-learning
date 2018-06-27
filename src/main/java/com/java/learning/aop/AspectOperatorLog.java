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

    /**
     * 切面于com.java.learning.aop.service下面的所有类
     */
    @Pointcut("within(com.java.learning.aop.service.*)")
    public void pointCut(){}

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("记录操作开始动作...");
    }

    @After("pointCut()")
    public void doAfter(){
        System.out.println("记录操作完成动作...");
    }

    @AfterReturning(returning = "result",pointcut = "args(Integer,..)")
    public void doAfterReturn(Object result){
        System.out.println("记录操作返回:"+result);
    }
    /**
     * 切面于 匹配所有update名字开头的方法
     */
    @AfterThrowing("execution(* update*(..))")
    public void doException(JoinPoint joinPoint){
        System.out.println("更新操作出现异常...");
    }
}
