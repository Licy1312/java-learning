package com.java.learning.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 商户管理
 * User:Lee
 * Date:2018/4/9
 */
public class MerchantManager {

    private static List<Merchant> merchantList;

    static {
        merchantList = Arrays.asList(
                new Merchant("商户1",1,new BigDecimal(100)),
                new Merchant("商户2",3,new BigDecimal(150)),
                new Merchant("商户3",2,new BigDecimal(300)),
                new Merchant("商户4",0,new BigDecimal(450)),
                new Merchant("商户5",1,new BigDecimal(600)),
                new Merchant("商户6",3,new BigDecimal(500)),
                new Merchant("商户7",2,new BigDecimal(810)),
                new Merchant("商户8",0,new BigDecimal(700)));
    }

    public static void main(String[] args){
        //1.获取SVIP商户
        System.out.println(filterSvipMerchant());


        //2.SVIP、余额大于等于500商户
        System.out.println(filterBalanceSvipMerchant(3, BigDecimal.valueOf(500)));



        //3.获取所有vip以上的商户
        System.out.println(filterVipMerchant(new VIPMerchantFilter()));



        //4.获取vip以上，其余额大于等于500的商户
        List<Merchant> resultList = filterVipMerchant(new MerchantFilter() {
            @Override
            public boolean filterMethod(Merchant merchant) {
                return merchant.getGrade()>=2 && merchant.getBalance().intValue()>=500;
            }
        });
        System.out.println(resultList);



        //5.余额大于600
        List<Merchant> vipMerchantList = filterVipMerchant((Merchant merchant)-> merchant.getBalance().intValue()>600);
        System.out.println(vipMerchantList);



        //6.余额小于等于100
        List<Merchant> minBalanceList = filterMethod(merchantList,(Merchant m)-> m.getBalance().intValue()<=100);
        System.out.println(minBalanceList);



    }


    private static List<Merchant> filterSvipMerchant(){
        List<Merchant> svipMerchant= new ArrayList<>();
        for(Merchant merchant : merchantList){
            if(merchant.getGrade()==3){
                svipMerchant.add(merchant);
            }
        }
        return svipMerchant;
    }

    private static List<Merchant> filterBalanceSvipMerchant(int grade,BigDecimal minBalance){
        List<Merchant> svipMerchant= new ArrayList<>();
        for(Merchant merchant : merchantList){
            if(merchant.getGrade()==grade && merchant.getBalance().compareTo(minBalance)>=0){
                svipMerchant.add(merchant);
            }
        }
        return svipMerchant;
    }







    private static List<Merchant> filterVipMerchant(MerchantFilter filter){
        List<Merchant> svipMerchant= new ArrayList<>();
        for(Merchant merchant : merchantList){
            if(filter.filterMethod(merchant)){
                svipMerchant.add(merchant);
            }
        }
        return svipMerchant;
    }








    private static<T> List<T> filterMethod(List<T> list,CommonFilter<T> filterObject){
        List<T> result = new ArrayList<>();
        for(T t : list){
            if(filterObject.filter(t)){
                result.add(t);
            }
        }
        return result;
    }



}
