package com.java.learning.current.future.rewriter;

/**
 * @author lee
 * @description:
 * @date:2019-07-09
 */
public class FutureData  implements Data{

    protected RealData realData = null;

    protected  boolean isReady;

    /**
     * 注入真实的返回结果
     * @param realData
     */
    public synchronized void setRealData(RealData realData){
        if(isReady){
            return;
        }

        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    /**
     * 获取真实的返回结果
     * @return
     */
    @Override
    public synchronized String getResult(){
        while(!isReady){
            try {

                System.out.println("商品未打包完成，等待商品打包完成");
                wait();
            }catch (InterruptedException e){

            }
        }
        System.out.println("确认打包完毕，获取运输中...");
        return realData.result;
    }
}
