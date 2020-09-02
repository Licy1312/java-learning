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

        SynchronizeApp synchronizeApp = new SynchronizeApp();
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                      //SynchronizeApp.synchronizedString(new String("aaaaa"));
                        synchronizeApp.method1("aaaaaa");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        synchronizeApp.method1("bbbbbb");
//                        //SynchronizeApp.synchronizedString("bbbbb");
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
        }

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
