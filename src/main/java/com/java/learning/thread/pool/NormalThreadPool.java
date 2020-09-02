package com.java.learning.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:正常的线程池用法
 *
 * @Author:Jinmu
 * Date: 2018/7/20
 */
public class NormalThreadPool {

    /**
     * 创建一个最大并发数固定的线程池
     * 当任务数量大于线程最大并发数时，线程池是不会再创建新的线程执行任务，而是等待正在执行的任务执行完成。
     */
    private static ExecutorService fixThreadPool = Executors.newFixedThreadPool(3);

    /**
     * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
     * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
     */
    private static ExecutorService cacheThreadPool = Executors.newCachedThreadPool();

    public static void main(String[] args){
        testFixThreadPool(5);

        System.out.println("test data 1");
//        testCacheThreadPool(10);
    }


    public static void testFixThreadPool(int num){
        for(int i=1;i<=num;i++){
            System.out.println("test data 2");
            fixThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int i= 1/0;
                    System.out.println("this tread"+Thread.currentThread().getName());

                }
            });
            System.out.println("test data 3");
        }
    }


    public static void testCacheThreadPool(int num){
        for(int i=1;i<=num;i++){
            cacheThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行线程"+Thread.currentThread().getName());
                }
            });
        }
    }
}
