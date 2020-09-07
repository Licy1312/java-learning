package com.java.learning.thread.pattern1;

import groovy.transform.Synchronized;

import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable{

    private final LinkedBlockingQueue<Integer> queue;

    public Producer(LinkedBlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            int i=0;
            while (true){

                synchronized(queue){
                    if (queue.size() == 100){
                        System.out.println("The queue is full,Producer pause.");
                        queue.wait();
                    }else{
                        System.out.println("Producer put: "+i);
                        queue.add(i++);
                        queue.notify();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
