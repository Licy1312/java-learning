package com.java.learning.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Date;
import java.util.concurrent.*;

public class AIOServer {
    private static Charset charset = Charset.forName("utf-8");
    private static CharsetEncoder encoder = charset.newEncoder();

    public static void main(String[] args) throws Exception {
        AsynchronousChannelGroup group = AsynchronousChannelGroup.withThreadPool(Executors.newFixedThreadPool(4));
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(group)
                .bind(new InetSocketAddress("127.0.0.1", 9999));

        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Void attachment) {
                try {
                    String now = new Date().toString();
                    ByteBuffer buffer = encoder.encode(CharBuffer.wrap(now + "\r\n"));
                    Future<Integer> f = result.write(buffer);
                    f.get();
                    System.out.println("received message: " + now);
                    result.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
            }
        });

        System.out.println("服务器启动等待连接: " + new Date().toString());

        group.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }
}
