package com.java.learning.groovy;

import groovy.lang.GroovyClassLoader;

import java.io.File;
import java.io.FileInputStream;

/**
 * @instruction:
 * @author: lee
 * @date: 2018/8/4
 */
public class DynamicGroovy {

    /**
     * 动态加载groovy脚步语言
     * @param filePath 文件路径
     * @return
     */
    public WeatherSubscriber getBeanByGroovyFile(String filePath) throws Exception {
        String groovyContent = getGroovyContent(filePath);
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(this.getClass().getClassLoader());
        Class tempObject = groovyClassLoader.parseClass(groovyContent);
        return (WeatherSubscriber)tempObject.newInstance();
    }

    /**
     * 获取脚步内容
     * @param filePath 文件路径
     * @return 字符串
     */
    private String getGroovyContent(String filePath){
        try{
            File file = new File(filePath);
            byte[] content = new byte[(int)file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(content);
            return new String(content,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
