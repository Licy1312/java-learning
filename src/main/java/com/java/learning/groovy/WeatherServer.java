package com.java.learning.groovy;

/**
 * @instruction: 天气发布服务接口（主题，即被观察者）
 * @author: lee
 * @date: 2018/8/4
 */
public interface WeatherServer {

    //增加订阅者
    void attach(WeatherSubscriber subscriber);

    //删除订阅者
    void detach(WeatherSubscriber subscriber);

    //推送天气通知
    void inform();
}
