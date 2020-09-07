package com.java.learning.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PayProxy implements InvocationHandler {

    public <T> T newInstance(Class<T> clz){
        return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz},this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this,args);
        }
        return null;
    }
}
