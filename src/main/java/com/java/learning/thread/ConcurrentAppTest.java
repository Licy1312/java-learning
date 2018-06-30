package com.java.learning.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: 测试类
 * User:Lee
 * Date:2018/6/30
 */
public class ConcurrentAppTest {

    public static void main(String[] args){
        LockApp lockApp = new LockApp(new ReentrantLock());
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lockApp.tryLockInterruptMethod(Thread.currentThread());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
