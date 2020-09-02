package com.java.learning.groovy.impl;

import com.java.learning.groovy.DynamicGroovy;
import com.java.learning.groovy.WeatherSubscriber;

/**
 * @instruction:
 * @author: lee
 * @date: 2018/8/4
 */
public class WeatherTestApp {

    public static void main(String[] args){
        try{
            ShanghaiWeatherServerImpl shanghaiWeatherServer = new ShanghaiWeatherServerImpl();
            shanghaiWeatherServer.setLatestWeatherInfo("晴，温度是25.5℃，风速为3级，注意防晒!");
            WeatherSubscriber weatherSubscriber = new DynamicGroovy().getBeanByGroovyFile("E:\\work\\day\\temp-note\\NewsOfficeSubscriberImpl.txt");
            shanghaiWeatherServer.attach(weatherSubscriber);
            shanghaiWeatherServer.inform();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
