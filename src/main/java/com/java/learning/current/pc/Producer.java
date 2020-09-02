package com.java.learning.current.pc;

/**
 * @author lee
 * @description:
 * @date:2019-07-14
 */
public class Producer implements Runnable{

    //缓存队列
    private BufferQueue dataBufferQueue;


    public void setDataBufferQueue(BufferQueue dataBufferQueue) {
        this.dataBufferQueue = dataBufferQueue;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            dataBufferQueue.put(String.valueOf(i));
            System.out.println("数据"+i+"已存入缓存队列");
        }

    }
}
