package socket;

import pool.ThreadPool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


/**
 * Server
 *
 * @author hakurei
 * @date 2019/5/4
 */
public class Server {


    private ServerSocketChannel serverSocketChannel;
    /**
     * 端口号
     */
    private int port=8080;


    /**
     * @author hakurei
     * 初始化
     * @date 13:55 2019/5/4
     **/
    public Server(){

        try {
            serverSocketChannel =ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listen() throws IOException {
         while (true){
             SocketChannel socketChannel =serverSocketChannel.accept();
                if (socketChannel!=null){
                    ThreadPool.getPool().getSingleThreadPool().execute(new ServerRunnable(socketChannel));
                }

         }
    }
}
