package com.java.learning.stream;

import com.java.learning.lambda.Merchant;
import com.java.learning.lambda.VIPMerchantFilter;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Description:
 *
 * @Author:Jinmu Date: 2018/6/7
 */
public class OptionalLearn {

    public static void main(String[] args) {
        Optional<Merchant> merchant = Optional.of(new Merchant("商户1", 1, new BigDecimal(100)));
//        Optional<Merchant> merchant = Optional.empty();
//        Optional<Merchant> merchant = Optional.ofNullable(null);
        merchant.ifPresent(System.out::println);
//        System.out.println(merchant.orElse(null));


        merchant.filter((Merchant user) -> user.getGrade()>0).ifPresent(System.out::println);

        VIPMerchantFilter vipMerchantFilter = new VIPMerchantFilter();
        vipMerchantFilter.dealMessage();
    }
}
