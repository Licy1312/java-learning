package com.java.learning.current.future.jdk;

import com.java.learning.current.future.rewriter.Data;
import com.java.learning.current.future.rewriter.FutureData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author Lee
 * @description:
 * @date:2019-07-09
 */
public class Main {
    public static void main(String args[]){
      try {
          FutureTask<String> futureTask = new FutureTask<String>(new RealData("商品"));

          ExecutorService executorService = Executors.newFixedThreadPool(1);
          executorService.submit(futureTask);

          System.out.println("等待收货期间，开始处理其他事情....");
          Thread.sleep(3000);
          System.out.println("等待收货期间，其他事情处理完成.");

//          System.out.println("收到货物:"+futureTask.get(8, TimeUnit.SECONDS));
          System.out.println("收到货物:"+futureTask.get());

          System.out.println("所有的任务是否都执行完成："+ executorService.isTerminated());
          executorService.shutdown();
          while (!executorService.isTerminated()) {
          }
          System.out.println("所有的任务是否都执行完成："+ executorService.isTerminated());
      }catch (Exception e){
        e.printStackTrace();
      }

    }
}
