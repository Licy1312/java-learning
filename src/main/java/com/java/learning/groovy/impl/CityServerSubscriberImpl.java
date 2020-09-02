package com.java.learning.groovy.impl;

import com.java.learning.groovy.WeatherSubscriber;


/**
 * @instruction: 城市服务
 * @author: lee
 * @date: 2018/8/4
 */
public class CityServerSubscriberImpl implements WeatherSubscriber {

    /**
     * 接收消息
     * @param weatherInfo 天气消息
     */
    @Override
    public void receive(String weatherInfo) {
        System.out.println("各位上海市民，上午好，当前市内天气情况:"+weatherInfo);
    }
}
