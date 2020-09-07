package com.java.learning.thread.pattern2;

public class ThreadApp {
    //flag==0代表可以打印字符串，flag==1代表可以打印数字
    private static Integer flag = 0;

    private static char c = 'A';

    private static int number = 1;


    public static void main(String[] args){

        ThreadApp threadApp = new ThreadApp();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (threadApp){
                        while (c<= 'Z')
                            if (flag == 0){
                                System.out.print(c++);
                                flag = 1;
                                threadApp.notifyAll();
                            }else{
                                try {
                                    threadApp.wait();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                    }

                }
            }).start();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (threadApp){
                        while (number<=26){
                            if (flag == 1){
                                System.out.print(number++);
                                flag = 0;
                                threadApp.notifyAll();
                            }else{
                                try {
                                    threadApp.wait();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    }

                }
            }).start();

    }
}
