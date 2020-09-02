package com.java.learning.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;

/**
 * @author Lee
 * @description:
 * @date:2019-08-14
 */
public class ServerApp {

    private static Charset charset = Charset.forName("utf-8");
    private static CharsetEncoder encoder = charset.newEncoder();

    public static void main(String[] args) throws Exception {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.bind(new InetSocketAddress(9999));

        //获取选择器
        Selector selector = Selector.open();
        server.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                //channel就绪，可以接收连接
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);

                    // 读事件就绪,可以读取数据
                }else if (selectionKey.isReadable()) {

                    //获取channel，然后写数据到buff中
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    buffer.clear();
                    int count = channel.read(buffer);
                    if(count >0 ){
                        buffer.flip();
                        System.out.println("received message:"+ String.valueOf((charset.decode(buffer)).array()));
                    }else {
                        //客户端有可能断开或者异常，这里主动关闭。
                        channel.close();
                    }
                }
            }
        }
    }
}
