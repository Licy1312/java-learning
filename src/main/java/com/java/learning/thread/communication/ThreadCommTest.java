package com.java.learning.thread.communication;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description: 线程间通信测试
 * 通信方式1：共享变量
 * 通信方式2：wait()/notify()
 * 通信方式3：管道通信
 *
 * @Author:Jinmu
 * Date: 2018/7/20
 */
public class ThreadCommTest {
    private static ExecutorService cacheThreadPool = Executors.newCachedThreadPool();

    public static void main(String[] args){
        //共享变量
        sharedParam();

        //阻塞和唤醒
        waitAndNotify();

        //管道通信
        pipingMethod();
    }

    /**
     * 方法1：共享变量。利用 synchronized 修饰对象或者类的静态方法达到修饰变量的目的。
     * 下面方法中的6个线程达到了共享变量的目的
     */
    public static void sharedParam(){
        for(int i=0;i<=5;i++){
            cacheThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    ThreadApp.sharedParamMethod();
                }
            });
        }
    }


    /**
     * 方法2：wait()/notify() 线程B-thread 检查a是否满足条件，不满足则进入阻塞。
     * 线程A-thread负责改变a的变量，当a达到指定值的时候唤醒阻塞中的线程B-thread。
     * 注意:线程B-thread要先启动，否则线程A-thread会唤醒一个不存在的线程。
     */
    public static void waitAndNotify(){

        try {
            ThreadApp threadApp = new ThreadApp();
            cacheThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    threadApp.waitAndNotifyMethod("B-thread");
                }
            });

            Thread.sleep(3000);

            cacheThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    threadApp.waitAndNotifyMethod("A-thread");
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /**
     * 方法3：管道通信 一个线程向管道中写数据，其他线程可以通过管道读取数据
     *
     */
    public static void pipingMethod(){
        try{
            //管道写入器
            PipedWriter writer = new PipedWriter();
            cacheThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //向管道中写数据
                    PipingWriter.writeMessage(writer);
                }
            });

            //管道读取器
            PipedReader reader = new PipedReader(writer);
            cacheThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //从管道中读数据
                    PipingReader.readMessage(reader);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
