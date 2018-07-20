package com.java.learning.thread.communication;

import java.io.IOException;
import java.io.PipedReader;

/**
 * Description:向管道中读数据类
 *
 * @Author:Jinmu
 * Date: 2018/7/20
 */
public class PipingReader {

    /**
     * 不停地从管道中读取数据
     * @Param reader 管道读对象
     */
    public static void readMessage(PipedReader reader){
        try {
            int count=0;
            while(true) {
                //在读取到内容之前，会一直阻塞
                char s = (char)reader.read();
                System.out.print("Read: " + s + ", ");
                if (++count % 5 == 0) {
                    System.out.println();
                }
            }
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
