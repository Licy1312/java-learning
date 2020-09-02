package com.java.learning.current.work;

/**
 * @author lee
 * @description:
 * @date:2019-07-13
 */
public class PulsWorker extends  Worker{

    public Object handle(Object input){
        Integer i = (Integer) input;
        return i*i*i;

    }
}
