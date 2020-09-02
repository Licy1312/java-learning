package com.java.learning.groovy.impl;

import com.java.learning.groovy.WeatherServer;
import com.java.learning.groovy.WeatherSubscriber;

import java.util.Vector;

/**
 * @instruction: 上海天气发布的服务，管理它的观察者，并通知天气消息
 * @author: lee
 * @date: 2018/8/4
 */
public class ShanghaiWeatherServerImpl  implements WeatherServer{

    //存放所有订阅者的队列
    Vector<WeatherSubscriber> subscriberQueue = new Vector<WeatherSubscriber>();

    private String latestWeatherInfo;

    /**
     * 添加订阅上海天气的订阅者
     * @param subscriber 订阅者
     */
    @Override
    public void attach(WeatherSubscriber subscriber) {
        subscriberQueue.addElement(subscriber);
    }

    /**
     * 删除订阅上海天气的订阅者
     * @param subscriber 订阅者
     */
    @Override
    public void detach(WeatherSubscriber subscriber) {
        subscriberQueue.removeElement(subscriber);
    }

    /**
     * 通知所有订阅上海天气的订阅者
     */
    @Override
    public void inform() {
        for (WeatherSubscriber subscriber : subscriberQueue)
            subscriber.receive(this.latestWeatherInfo);
    }


    public void setLatestWeatherInfo(String latestWeatherInfo) {
        this.latestWeatherInfo = latestWeatherInfo;
    }
}
