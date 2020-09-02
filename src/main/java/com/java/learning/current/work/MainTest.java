package com.java.learning.current.work;

import java.util.Map;
import java.util.Set;

/**
 * @author lee
 * @description:
 * @date:2019-07-13
 */
public class MainTest {

    public static void main(String[] args){
        Master master = new Master(new PulsWorker(),5);

        for(int i=1;i<=1000;i++){
            master.submit(i);
        }
        master.execute();

        int result =0;
        Map<String,Object> resultMap = master.getResultMap();

        while (resultMap.size()>0 || !master.isComplete()){
            Set<String> keys = resultMap.keySet();
            String key = null;
            for(String k:keys){
                key = k;
                break;
            }

            Integer i = null;
            if(key != null){
                i = (Integer)resultMap.get(key);
            }
            if (i != null){
                result += i;
            }

            if(key != null){
                resultMap.remove(key);
            }
        }

        System.out.println(result);
    }
}
