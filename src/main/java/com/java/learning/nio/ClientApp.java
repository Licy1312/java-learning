package com.java.learning.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;

/**
 * @author Lee
 * @description:
 * @date:2019-08-14
 */
public class ClientApp {

    public static void main(String[] args) throws  Exception{

        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
        socketChannel.configureBlocking(false);

        //获取选择器
        Selector selector = Selector.open();

        //将通道注册到选择器中，获取服务端返回的数据
        socketChannel.register(selector, SelectionKey.OP_READ);

        while (true){
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String message = new Date().toString();
            System.out.println("client send:"+message);
            buffer.put(message.getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();

            Thread.sleep(5000);
        }



//        // 5. 轮训地获取选择器上已“就绪”的事件--->只要select()>0，说明已就绪
//        while (selector.select() > 0) {
//            // 6. 获取当前选择器所有注册的“选择键”(已就绪的监听事件)
//            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
//
//            // 7. 获取已“就绪”的事件，(不同的事件做不同的事)
//            while (iterator.hasNext()) {
//
//                SelectionKey selectionKey = iterator.next();
//
//                // 8. 读事件就绪
//                if (selectionKey.isReadable()) {
//
//                    // 8.1得到对应的通道
//                    SocketChannel channel = (SocketChannel) selectionKey.channel();
//
//                    ByteBuffer responseBuffer = ByteBuffer.allocate(1024);
//
//                    // 9. 知道服务端要返回响应的数据给客户端，客户端在这里接收
//                    int readBytes = channel.read(responseBuffer);
//
//                    if (readBytes > 0) {
//                        // 切换读模式
//                        responseBuffer.flip();
//                        System.out.println(new String(responseBuffer.array(), 0, readBytes));
//                    }
//                }
//
//                // 10. 取消选择键(已经处理过的事件，就应该取消掉了)
//                iterator.remove();
//            }
//        }

    }
}
