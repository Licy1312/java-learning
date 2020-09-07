package com.java.learning.thread.pattern1;

import groovy.transform.Synchronized;

import java.util.Hashtable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者-消费者模式
 * 消息队列池：共享的、要加锁
 * 生产者：队列满了，则暂停生产
 * 消费者：队列空了，则暂停消费
 *
 */
public class ThreadApp {

    private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args){

        policyTwo();
    }

    /**
     * 策略1：一个生产者线程循环处理，一个消费者线程循环处理
     */
    public static void policyOne(){
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }

    /**
     * 策略2：多个生产者线程循环处理，多个消费者线程循环处理
     */
    public static void policyTwo(){

        for (int i=0;i<100;i++){
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (size() == 50){
                        System.out.println("The queue is full,Producer pause.");
                    }else{
                        put(finalI);
                        System.out.println("Producer put: "+finalI);
                    }

                }
            }).start();
        }


        for (int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (size() == 0){
                        System.out.println("The queue is empty,Consumer pause.");

                    }else {
                        System.out.println("Consumer get: "+get());
                    }

                }
            }).start();
        }
    }




    private static synchronized void put(int value){
        queue.add(value);
    }

    private static synchronized int get(){
        return queue.poll();
    }

    private static synchronized int size(){
        return queue.size();
    }


}
