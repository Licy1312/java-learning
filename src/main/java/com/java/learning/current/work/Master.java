package com.java.learning.current.work;


import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author lee
 * @description:
 * @date:2019-07-13
 */
public class Master {
    //任务队列
    protected Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();

    //线程队列
    protected Map<String, Thread> threadMap = new HashMap<String, Thread>();

    //结果集
    protected Map<String, Object> resultMap = new ConcurrentHashMap<>();

    //构造函数，指定线程类型是worker，以及对应的个数
    public Master(Worker worker,int countWorker){
        worker.setWorkQuue(workQueue);

        worker.setResultMap(resultMap);

        for(int i=0;i<countWorker;i++){
            threadMap.put(Integer.toString(i),new Thread(worker,Integer.toString(i)));
        }
    }

    //提交任务
    public void submit(Object job){
        workQueue.add(job);
    }

    public Map<String, Object> getResultMap(){
        return resultMap;
    }

    //是否所有子任务都结束了
    public boolean isComplete(){
        for(Map.Entry<String,Thread> entry:threadMap.entrySet()){
            if(entry.getValue().getState() != Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }

    //开始运行所有的work线程
    public void execute(){
        for(Map.Entry<String,Thread> entry: threadMap.entrySet()){
            entry.getValue().start();
        }
    }
}
