package com.java.learning.thread;

/**
 * Description: 同步代码的学习（synchronized）
 * User:Lee
 * Date:2018/6/30
 */
public class SynchronizeApp {

    private static int b=0;

    //保证该类同一个对象调用该方法是有序的。
    public synchronized void objectMethod(Thread thread){
        System.out.println("线程"+thread.getName()+"开始"+b);
        for(int i=0;i<5;i++){
            b++;
        }
        System.out.println("线程"+thread.getName()+"结束"+b);
    }

    //保证该类，及其所有实例化的对象调用该方法都是有序的
    public static synchronized  void staticMethod(Thread thread){
        System.out.println("线程"+thread.getName()+"开始"+b);
        for(int i=0;i<5;i++){
            b++;
        }
        System.out.println("线程"+thread.getName()+"结束"+b);
    }

    public void pieceClassMethod(Thread thread){
        //根据括号里面指定的类调用该代码块都是有序的，这里指的是该类
        synchronized (this){
            System.out.println("线程"+thread.getName()+"开始"+b);
            for(int i=0;i<5;i++){
                b++;
            }
            System.out.println("线程"+thread.getName()+"结束"+b);
        }
    }
}
