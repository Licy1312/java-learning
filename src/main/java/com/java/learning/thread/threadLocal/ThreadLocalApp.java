package com.java.learning.thread.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalApp {

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(10);
    public static String date2String(int millisSeconds){
        Date now = new Date(millisSeconds);
        return DateFormat.dateFormatThreadLocal.get().format(now);
//        return DateFormat.get().format(now);
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            int j=i;
            threadPool.execute(()->{
                String result = date2String(j*1000);
                System.out.println(Thread.currentThread().getName()+" date: "+ result);
            });
        }
    }

}

class DateFormat{
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> {
        System.out.println(Thread.currentThread().getName()+" init simpleDateFormat");
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    });

    public static SimpleDateFormat get(){
        System.out.println(Thread.currentThread().getName()+" init simpleDateFormat");
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }
}
