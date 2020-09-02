package com.java.learning.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;

/**
 * @author lee
 * @description:
 * @date:2019-08-14
 */
public class AIOClient {

    public static void main(String[] args) throws Exception {
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        Future<Void> future = client.connect(new InetSocketAddress("127.0.0.1", 9999));
        future.get();

        ByteBuffer buffer = ByteBuffer.allocate(100);
        client.read(buffer, null, new CompletionHandler<Integer, Void>() {
            //读取完成时执行
            @Override
            public void completed(Integer result, Void attachment){
                System.out.println("client received: " + new String(buffer.array()));
            }
            //读取异常时执行
            @Override
            public void failed(Throwable exc, Void attachment) {
                try {
                    client.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
