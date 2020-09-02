package com.java.learning.velocity;

public class FtpUtil {

    public String getResult(String ...people){
        String result ="";
        for (int i=0; i<people.length;i++){
            result += people[i];
        }
        return result;
    }
    public String getAllResult(String name,String age){
        return name+','+age;
    }
}
