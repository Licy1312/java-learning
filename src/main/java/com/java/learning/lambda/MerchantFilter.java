package com.java.learning.lambda;

/**
 * Description:商户过滤接口
 * User:Lee
 * Date:2018/4/9
 */
public interface MerchantFilter {

    boolean filterMethod(Merchant merchant);

    default void sendMessage(){
        System.out.println("This is merchant filter!");
    }

    static void receivedMessage(){
        System.out.println("I had received a message!");
    }

    @Override
    String toString();

    boolean equals(Object o);


}
