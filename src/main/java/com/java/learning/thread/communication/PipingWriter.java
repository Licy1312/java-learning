package com.java.learning.thread.communication;

import java.io.PipedWriter;
import java.util.concurrent.TimeUnit;

/**
 * Description: 向管道中写数据类
 *
 * @Author:Jinmu
 * Date: 2018/7/20
 */
public class PipingWriter {

    /**
     * 不停地向管道中写信息
     * @Param writer 管道写对象
     */
    public static void writeMessage(PipedWriter writer){
        try {
            while(true) {
                for (char c = 'A'; c < 'z'; c++) {
                    writer.write(c);
                    TimeUnit.SECONDS.sleep(1);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
