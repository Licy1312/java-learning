package com.java.learning.lambda;

/**
 * Description:通用过滤器
 * User:Lee
 * Date:2018/4/9
 */
public interface CommonFilter<T> {

    boolean filter(T t);
}
