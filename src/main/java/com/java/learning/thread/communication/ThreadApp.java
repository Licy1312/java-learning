package com.java.learning.thread.communication;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Calendar;

/**
 * Description: 线程体
 *
 * @Author:Jinmu
 * Date: 2018/7/20
 */
public class ThreadApp {

    private static int a = 100;


    //保证该类，及其所有实例化的对象调用该方法都是有序的
    public synchronized static void sharedParamMethod(){
        System.out.println("变量a的值为:"+a--);
    }

    //保证该类同一个对象调用该方法是有序的。
    public void waitAndNotifyMethod(String threadName){
        try{
            synchronized(this){
                if(threadName.equals("A-thread")){
                    while (a>0){
                        System.out.println("A-thread,当前a的值:"+a);
                        a =a-5;
                        if(a==50){
                            System.out.println("A-thread 发送消息唤醒 B-thread!");
                            this.notify();
                        }
                    }
                }
                if(threadName.equals("B-thread")){
                    if(a!=50){
                        System.out.println("B-thread,让出CPU等待!");
                        this.wait();
                        a =+100;
                        System.out.println("B-thread,被唤醒，重新改变变量a的值:"+a);
                    }

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
