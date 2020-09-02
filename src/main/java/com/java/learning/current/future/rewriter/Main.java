package com.java.learning.current.future.rewriter;

/**
 * @author Lee
 * @description:
 * @date:2019-07-09
 */
public class Main {
    public static void main(String args[]){
        Main main = new Main();
        Data data = main.request("商品");
        try{
            System.out.println("等待收货期间，开始处理其他事情....");
            Thread.sleep(3000);
            System.out.println("等待收货期间，其他事情处理完成.");
        }catch (InterruptedException e){

        }

        System.out.println("收到货物:"+data.getResult());
    }

    public Data request(final String queryString){
        final FutureData futureData = new FutureData();
        new Thread(() -> {
            RealData realData = new RealData(queryString);
            futureData.setRealData(realData);
        }).start();
        return futureData;
    }
}
