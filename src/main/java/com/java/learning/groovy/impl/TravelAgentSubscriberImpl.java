package com.java.learning.groovy.impl;

import com.java.learning.groovy.WeatherSubscriber;

import java.util.Date;

/**
 * @instruction: 旅行社订阅者，
 * @author: lee
 * @date: 2018/8/4
 */
public class TravelAgentSubscriberImpl implements WeatherSubscriber {

    /**
     * 接收消息
     * @param weatherInfo 天气消息
     */
    @Override
    public void receive(String weatherInfo) {
        System.out.println("各位游客,上海市当前"+new Date()+"天气情况:"+weatherInfo);
    }
}
