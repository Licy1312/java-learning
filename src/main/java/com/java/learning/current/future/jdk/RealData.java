package com.java.learning.current.future.jdk;

import java.util.concurrent.Callable;

/**
 * @author lee
 * @description:
 * @date:2019-07-09
 */
public class RealData implements Callable<String> {
    private String param;

    public RealData(String param){
        this.param = param;
    }

    @Override
    public String call() throws Exception {

        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0; i<10; i++){
            stringBuffer.append(" "+param);
            try {
                Thread.sleep(1000);
                System.out.println("第"+(i+1)+"件商品打包完成!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }
}
