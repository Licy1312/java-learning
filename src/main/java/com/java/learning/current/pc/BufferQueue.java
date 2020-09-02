package com.java.learning.current.pc;

import java.util.Queue;

/**
 * @author lee
 * @description:
 * @date:2019-07-14
 */
public final class BufferQueue {

    private Queue<String> bufferData;

    private int bufferSize;


    //构造函数私有化
    public BufferQueue(Queue<String> bufferData,int bufferSize){
      this.bufferData = bufferData;
      this.bufferSize = bufferSize;
    }


    /**
     * 向缓存区中存放数据
     * @param data 数据
     */
    public synchronized void put(String data){
        //缓存区已经满了
        while(bufferData.size() == bufferSize){
            try {
                System.out.println("当前数据缓存队列已满，无法添加数据，需要等待消费！");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        bufferData.add(data);
    }

    /**
     * 取缓存区中的数据
     * @return
     */
    public synchronized String poll(){
      while (bufferData.size() == 0){
          try {
              System.out.println("当前数据缓存队列为空，无法获取数据，需要等待添加!");
              this.wait();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
      this.notify();
      return bufferData.poll();
    }

    public void getSize(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
