package com.java.learning.current.pc;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lee
 * @description:
 * @date:2019-07-14
 */
public class MainTest {

    public static void main(String[] args){
        BufferQueue bufferQueue = new BufferQueue(new ConcurrentLinkedQueue<String>(),10);
        Consumer consumer = new Consumer();
        consumer.setDataBufferQueue(bufferQueue);

        Producer producer = new Producer();
        producer.setDataBufferQueue(bufferQueue);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(consumer);
        executorService.execute(producer);
    }
}
