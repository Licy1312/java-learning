//package com.java.learning.httpClient;
//
//
//import org.apache.http.client.HttpClient;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class SendMessageClient{
//
//    public static boolean flag = false;
//
//    public static Map<String, HttpClient> instanceMap = new ConcurrentHashMap<>();
//
//    private static IdleConnectionTimeoutThread idleConnectionTimeoutThread = new IdleConnectionTimeoutThread();
//
//    /**
//     * 初始化httpClient
//     * @return
//     */
//    private HttpClient initHttpClient(){
//        System.out.println("init pool!");
//        //连接管理参数
//        HttpConnectionManagerParams connectionManagerParams = new HttpConnectionManagerParams();
//        connectionManagerParams.setConnectionTimeout(10000);
//        connectionManagerParams.setSoTimeout(10000);
//        connectionManagerParams.setDefaultMaxConnectionsPerHost(10);
//        connectionManagerParams.setMaxTotalConnections(10);
//
//        //使用连接池
//        HttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
//        connectionManager.setParams(connectionManagerParams);
//
//        HttpClient client = new HttpClient(connectionManager);
//        client.getParams().setConnectionManagerTimeout(10000);
//        idleConnectionTimeoutThread.addConnectionManager(connectionManager);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int i=0;
//                while (i<1000){
//                    try {
//                        i++;
//                        Thread.sleep(1000);
//                        getConnectionPoolSize(Thread.currentThread().getName(),(MultiThreadedHttpConnectionManager) connectionManager);
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//        return client;
//    }
//
//    private HttpClient getClient(String key){
//        try {
//            HttpClient client = instanceMap.get(key);
//
//            if (client == null) {
//                synchronized (instanceMap) {
//                    if ((client = instanceMap.get(key)) == null) {
//                        //创建客户端
//                        client = initHttpClient();
//                        instanceMap.put(key, client);
//                    }
//                }
//            }
//            return client;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void clearClient(){
//        instanceMap.clear();
//        System.out.println(instanceMap.size()+",clear pool!");
//    }
//
//    public void sendMessage(){
//        String url = "";
//        HttpClient httpClient = getClient("100");
//        PostMethod  httpMethod = new PostMethod(url);
//
//        //添加请求头
//        httpMethod.addRequestHeader("Content-Type","application/json");
//
//        //添加请求体
//        try {
//            httpMethod.setRequestEntity(new StringRequestEntity(content, null,"GBK"));
//            httpClient.executeMethod(httpMethod);
//            System.out.println("http status:"+httpMethod.getStatusCode());
//            System.out.println("http response:"+httpMethod.getResponseBodyAsString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void getConnectionPoolSize(String threadName ,MultiThreadedHttpConnectionManager manager){
//        System.out.println(threadName+",this pool:"+manager.hashCode()+",connections:"+manager.getConnectionsInPool());
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(10000);
//                    if (!flag){
//                        manager.shutdown();
//                    }
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//
//    public void startDeleteIdleConnection(){
//        idleConnectionTimeoutThread.start();
//        System.out.println("delete invalid connection");
//    }
//
//    public void shutDownAllConnectPool(){
//        MultiThreadedHttpConnectionManager.shutdownAll();
//        System.out.println("shutdown all connectPool");
//    }
//}
