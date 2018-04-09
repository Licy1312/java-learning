package com.java.learning.lambda;

/**
 * Description: vip商户过滤
 * User:Lee
 * Date:2018/4/9
 */
public class VIPMerchantFilter implements MerchantFilter {

    @Override
    public boolean filterMethod(Merchant merchant) {
        return merchant.getGrade()>=2;
    }
}
