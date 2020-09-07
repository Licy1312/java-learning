package com.java.learning.thread.pattern1;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable{

    private final LinkedBlockingQueue<Integer> queue;

    public Consumer(LinkedBlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while (true){

                synchronized (queue){
                    if (queue.isEmpty()){
                        System.out.println("The queue is empty,Consumer pause.");
                        queue.wait();
                    }else{
                        int i= queue.poll();
                        System.out.println("Consumer get: "+i);
                        queue.notify();
                    }
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
