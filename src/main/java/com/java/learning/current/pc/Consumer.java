package com.java.learning.current.pc;


/**
 * @author lee
 * @description:
 * @date:2019-07-14
 */
public class Consumer implements Runnable{

    //缓存队列
    private BufferQueue dataBufferQueue;


    public void setDataBufferQueue(BufferQueue dataBufferQueue) {
        this.dataBufferQueue = dataBufferQueue;
    }



    @Override
    public void run() {
        for(int i=0;i<20;i++){
            String data = dataBufferQueue.poll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("数据"+data+"已取出缓存队列");
        }
    }
}
