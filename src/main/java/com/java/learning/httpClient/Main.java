//package com.java.learning.httpClient;
//
//public class Main {
//
//    public static void main(String[] args) {
//        SendMessageClient sendMessageClient = new SendMessageClient();
////        sendMessageClient.startDeleteIdleConnection();
//        //定时任务发送消息
//        for(int i=0;i<100;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//
//                            Thread.sleep(((int)Math.random()*100)*1000);
//                            sendMessageClient.sendMessage();
//                            System.out.println("client num:"+SendMessageClient.instanceMap.size());
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(10000);
//                    sendMessageClient.shutDownAllConnectPool();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        //定时任务刷新client
//        while (true){
//            try {
//                Thread.sleep(2000);
//                SendMessageClient.clearClient();
//                sendMessageClient.sendMessage();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
////        try {
////            //主线程 阻塞
////            Thread.sleep(30*60*1000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//
//
//    }
//}
