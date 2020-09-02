package com.java.learning.current.future.rewriter;

/**
 * @author Lee
 * @description:
 * @date:2019-07-09
 */
public class RealData implements Data {

    protected final String result;

    /**
     * 构造方法，对结果进行赋值
     * @param param
     */
    public RealData(String param){
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
        result = stringBuffer.toString();
    }


    /**
     * 实现接口，返回结果
     * @return
     */
    @Override
    public String getResult() {
        return result;
    }
}
