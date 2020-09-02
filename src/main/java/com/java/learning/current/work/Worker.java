package com.java.learning.current.work;

import java.util.Map;
import java.util.Queue;

/**
 * @author Lee
 * @description:
 * @date:2019-07-13
 */
public class Worker implements Runnable{

    protected Queue<Object> workQuue;

    protected Map<String,Object> resultMap;

    public void setWorkQuue(Queue<Object> workQuue) {
        this.workQuue = workQuue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        while (true){
            //获取队列中的任务
            Object task = workQuue.poll();
            if(task == null){
                break;
            }
            Object result = handle(task);

            resultMap.put(Integer.toString(task.hashCode()),result);
        }
    }

    public Object handle(Object task) {
        return task;
    }
}
